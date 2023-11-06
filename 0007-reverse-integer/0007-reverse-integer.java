/**
num = 0, x = 123
num = 10 * num + x % 10 -> num = 10 * 0 + 123 % 10 -> num = 0 + 3 -> num = 3
x = x / 10 -> x = 123 / 10 -> x = 12

num = 3, x = 12
num = 10 * num + x % 10 -> num = 10 * 3 + 12 % 10 -> num = 30 + 2 -> num = 32
x = x / 10 -> x = 12 / 10 -> x = 1

num = 32, x = 1
num = 10 * num + x % 10 -> num = 10 * 32 + 1 % 10 -> num = 320 + 1 -> num = 321
x = x / 10 -> x = 1 / 10 -> x = 0
*/
class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;

        x = Math.abs(x);    
        int result = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }

        return negative ? -result : result;
    }
}