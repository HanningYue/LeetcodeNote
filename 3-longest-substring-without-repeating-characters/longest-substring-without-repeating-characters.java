class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char jChar = s.charAt(j);
            if (map.containsKey(jChar)) {
                i = Math.max(map.get(jChar), i);
            }
            map.put(jChar, j + 1);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}