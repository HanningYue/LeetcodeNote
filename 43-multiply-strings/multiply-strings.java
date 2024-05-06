/**
    1   2   3
        5   6
    _________
    [0 1 2 3 4]
        1   8
    1   2
    6
*/
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] resultArray = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int numOne = num1.charAt(i) - '0';
                int numTwo = num2.charAt(j) - '0';

                int product = numOne * numTwo;
                int sum = product + resultArray[i + j + 1];
                resultArray[i + j + 1] = sum % 10;
                resultArray[i + j] = resultArray[i + j] + sum / 10;
            }
        }

        int k = 0;
        while (k < resultArray.length && resultArray[k] == 0) {
            k++;
        }

        StringBuilder sb = new StringBuilder();
        while (k < resultArray.length) {
            sb.append(resultArray[k]);
            k++;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}