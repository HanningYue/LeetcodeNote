class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int finalLength = 0;
        boolean odd = false;
        for (int value : map.values()) {
            if (value % 2 == 0) {
                finalLength += value;
            } else {
                finalLength += value - 1;
                odd = true;
            }
        }
        if (odd) {
            finalLength += 1;
        }
        return finalLength;
    }
}