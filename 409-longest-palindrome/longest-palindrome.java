class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        boolean odd = false;
        for (int frequency : map.values()) {
            if (frequency % 2 == 0) {
                result += frequency;
            } else {
                result += frequency - 1;
                odd = true;
            }
        }
        if (odd) {
            result += 1;
        }
        return result;
    }
}