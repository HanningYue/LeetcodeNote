class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSum(slow);
            fast = digitSum(digitSum(fast));
        } while (slow != fast);
        return slow == 1;
    }
    private int digitSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}