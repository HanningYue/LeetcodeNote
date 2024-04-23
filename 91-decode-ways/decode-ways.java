class Solution {
    private Integer[] memo;

    public int numDecodings(String s) {
        memo = new Integer[s.length()];
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        // When index reaches the end of the string
        if (index == s.length()) return 1;  // Successfully decoded

        // If the string starts with a zero, it cannot be decoded
        if (s.charAt(index) == '0') return 0;

        // Return cached result if already computed
        if (memo[index] != null) return memo[index];

        // Decode using one character
        int result = decode(s, index + 1);

        // Decode using two characters if possible
        if (index < s.length() - 1) {
            int twoDigits = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
            if (twoDigits >= 10 && twoDigits <= 26) {
                result += decode(s, index + 2);
            }
        }

        // Cache the result before returning
        memo[index] = result;
        return result;
    }
}
