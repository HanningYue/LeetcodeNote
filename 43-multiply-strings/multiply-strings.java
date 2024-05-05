class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num1Last = num1.charAt(i) - '0';
                int num2Last = num2.charAt(j) - '0';

                int product = num1Last * num2Last;
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] = result[i + j] + sum / 10;
            }
        }
        
        int k = 0;
        while (k < result.length && result[k] == 0) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        while (k < result.length) {
            sb.append(result[k]);
            k++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}