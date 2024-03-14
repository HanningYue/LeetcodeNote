class Solution {
    public String addBinary(String a, String b) {
        int pointerA = a.length() - 1, pointerB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (pointerA >= 0 || pointerB >= 0) {
            int numA = pointerA >= 0 ? a.charAt(pointerA) - '0' : 0;
            int numB = pointerB >= 0 ? b.charAt(pointerB) - '0' : 0;
            int sum = numA + numB + carry;

            carry = sum / 2;
            sb.insert(0, sum % 2);
            pointerA--;
            pointerB--;
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}