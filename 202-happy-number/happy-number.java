class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        } while (slow != fast);

        return slow == 1;
    }
    private int findSum(int num) {
        int sum = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            sum += lastDigit * lastDigit;
            num = num / 10;
        }
        return sum;
    }
}