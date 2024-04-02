class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        do {
            slow = process(slow);
            fast = process(process(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    private int process(int n) {
        int sum = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n = n / 10;
        }
        return sum;
    }
}