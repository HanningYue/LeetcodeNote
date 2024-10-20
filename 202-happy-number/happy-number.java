class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = process(slow);
            fast = process(process(fast));
        } while (slow != fast);
        return slow == 1 ? true : false;
    }
    private int process(int num) {
        int sum = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            sum = sum + lastDigit * lastDigit;
            num = num / 10;
        }
        return sum;
    }
}