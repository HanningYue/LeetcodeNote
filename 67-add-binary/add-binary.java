class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1, p2 = b.length() - 1;
        
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int num1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int num2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int sum = num1 + num2 + carry;

            sb.insert(0, sum % 2);
            carry = sum / 2;
            p1--;
            p2--;
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}