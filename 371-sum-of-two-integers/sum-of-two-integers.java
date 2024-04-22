class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }

        while (b != 0) {
            int carryToLeft = a & b;
            int addWithoutCarry = a ^ b;
            a = addWithoutCarry;
            b = carryToLeft << 1;
        }
        return a;
    }
}