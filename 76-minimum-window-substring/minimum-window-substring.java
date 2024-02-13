class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int minLength = Integer.MAX_VALUE;
        int slow = 0, fast = 0, match = 0;
        while (fast < s.length()) {
            char sChar = s.charAt(fast);
            if (map.containsKey(sChar)) {
                map.put(sChar, map.get(sChar) - 1);
                if (map.get(sChar) >= 0) {
                    match++;
                }
            }
            while (match == t.length()) {
                if (fast - slow + 1 < minLength) {
                    minLength = Math.min(minLength, fast - slow + 1);
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