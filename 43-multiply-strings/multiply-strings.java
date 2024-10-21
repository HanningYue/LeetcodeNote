class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int numberOne = num1.charAt(i) - '0';
                int numberTwo = num2.charAt(j) - '0';
                int product = numberOne * numberTwo;
                int sum = result[i + j + 1] + product;
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