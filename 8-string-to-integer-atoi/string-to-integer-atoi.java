class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long result = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        if (i == s.length()) {
            return 0;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        if ((int) result != result) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return (int) result * sign;

    }
}