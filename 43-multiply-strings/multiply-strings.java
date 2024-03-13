class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int product = ((num2.charAt(i) - '0') * (num1.charAt(j) - '0'));
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
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
// index           0   1   2
//                 1   2   3
//                 4   5   6
//             ________________
//                     1   8
//                 1   2
//                 6
//                 1   5
//             1   0 
//             5
//             1   2   
//             8
//         4
//     0   1   2   3   4   5   
//                         i + j + 1
//                     i + j