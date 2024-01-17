class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int slow = 0, length = Integer.MAX_VALUE;
        String result = "";
        int matchChar = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    matchChar ++;
                }
            }

            while (matchChar == t.length()) {
                if (length > fast - slow + 1) {
                    length = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }
                c = s.charAt(slow);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        matchChar--;
                    }
                }
                slow++;
            }
        }
        return result;
    }
}