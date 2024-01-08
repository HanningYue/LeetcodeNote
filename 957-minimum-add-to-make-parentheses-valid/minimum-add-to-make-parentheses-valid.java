/**
Why ifAllClose? Think of this scenario: ))))))), we can add just one ( at the very front to make it valid. After that, we need to set the balance between opening and closing bracket to 0;
*/
class Solution {
    public int minAddToMakeValid(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int balance = 0;
        int ifAllClose = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                ifAllClose++;
                balance = 0;
            }
        }
        int sum = ifAllClose + balance;
        return sum;
    }
}