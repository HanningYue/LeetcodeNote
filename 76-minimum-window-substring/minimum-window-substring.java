class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        String result = "";
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            while (allZero(map)) {
                if (fast - slow + 1 < length) {
                    length = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }
                c = s.charAt(slow);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                slow++;
            }
            fast++;
        }
        return result;
    }
    private boolean allZero(Map<Character, Integer> map) {
        for (int value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}