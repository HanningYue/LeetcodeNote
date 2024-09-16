class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);

        if (y > x) {
            return getSum(b, a);
        }

        int sign = a > 0 ? 1 : -1;
        
        if (a * b >= 0) {
            while (y != 0) {
                int sum = x ^ y;
                int carryToLeft = (x & y) << 1;
                x = sum;
                y = carryToLeft;
            }
        } else if (a * b < 0) {
            while (y != 0) {
                int sum = x ^ y;
                int carryToLeft = ((~x) & y) << 1;
                x = sum;
                y = carryToLeft;
            }
        }

        return x * sign;
    }
}