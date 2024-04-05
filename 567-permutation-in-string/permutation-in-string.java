class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int slow = 0, fast = 0, match = 0;
        while (fast < s2.length()) {
            char fastChar = s2.charAt(fast);
            if (map.containsKey(fastChar)) {
                map.put(fastChar, map.get(fastChar) - 1);
                if (map.get(fastChar) >= 0) {
                    match++;
                }
            }

            if (fast - slow + 1 == s1.length()) {
                if (match == s1.length()) {
                    return true;
                }
                char slowChar = s2.charAt(slow);
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
        return false;
    }
}