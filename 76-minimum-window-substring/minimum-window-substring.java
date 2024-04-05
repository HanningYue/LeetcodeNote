class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int slow = 0, fast = 0;
        int match = 0, length = Integer.MAX_VALUE;
        String result = "";
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                map.put(fastChar, map.get(fastChar) - 1);
                if (map.get(fastChar) >= 0) {
                    match++;
                }
            }

            while (match == t.length()) {
                if (fast - slow + 1 < length) {
                    length = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }

                char slowChar = s.charAt(slow);
                if (map.containsKey(slowChar)) {
                    map.put(slowChar, map.get(slowChar) + 1);
                    if (map.get(slowChar) > 0) {
                        match--;
                    }
                }
                slow++;
            }
            fast++;
        }
        return result;
    }
}