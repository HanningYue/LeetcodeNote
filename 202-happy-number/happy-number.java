class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = process(n);
        while (slow != fast) {
            slow = process(slow);
            fast = process(process(fast));
        }
        return slow == 1;
    }
    private int process(int num) {
        int result = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            result += lastDigit * lastDigit;
            num = num / 10;
        }
        return result;
    }
}