class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int one = num1.charAt(i) - '0';
                int two = num2.charAt(j) - '0';

                int product = one * two;
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] = result[i + j] + sum / 10;
            }
        }
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < result.length) {
            sb.append(result[i]);
            i++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}