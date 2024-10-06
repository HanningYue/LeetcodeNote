class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                map.put(fastChar, map.get(fastChar) - 1);
                if (map.get(fastChar) >= 0) {
                    match++;
                }
            }

            if (fast - slow + 1 == p.length()) {
                if (match == p.length()) {
                    result.add(slow);
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