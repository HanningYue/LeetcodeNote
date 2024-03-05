class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aPointer = a.length() - 1, bPointer = b.length() - 1;
        
        int carry = 0;
        while (aPointer >= 0 || bPointer >= 0) {
            int num1 = aPointer >= 0 ? a.charAt(aPointer) - '0' : 0;
            int num2 = bPointer >= 0 ? b.charAt(bPointer) - '0' : 0;
            int sum = carry + num1 + num2;

            sb.insert(0, sum % 2);
            carry = sum / 2;
            aPointer--;
            bPointer--;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}