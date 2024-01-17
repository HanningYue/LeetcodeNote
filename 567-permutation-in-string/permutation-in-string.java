class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int slow = 0, fast = 0;
        while (fast < s2.length()) {
            char c = s2.charAt(fast);
            if (map.containsKey(c)) 
                map.put(c, map.get(c) - 1);
            if (allZero(map)) 
                return true;

            while (fast - slow + 1 == s1.length()) {
                c = s2.charAt(slow);
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                slow++;
            }
            fast++;
        }
        return false;
    }
    private boolean allZero(Map<Character, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}