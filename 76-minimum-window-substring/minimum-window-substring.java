class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int length = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        int match = 0;

        while (fast < s.length()) {
            char current = s.charAt(fast);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) >= 0) {
                    match++;
                }
            }

            while (match == t.length()) {
                if (fast - slow < length) {
                    length = fast - slow + 1;
                    result = s.substring(slow, slow + length);
                }

                current = s.charAt(slow);
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                    if (map.get(current) > 0) {
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