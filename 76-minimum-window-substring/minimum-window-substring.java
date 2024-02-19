class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int slow = 0, fast = 0, match = 0;
        String result = "";
        int length = Integer.MAX_VALUE;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    match++;
                }
            }

            while (match == t.length()) {
                if (length > fast - slow + 1) {
                    length = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }
                c = s.charAt(slow);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
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