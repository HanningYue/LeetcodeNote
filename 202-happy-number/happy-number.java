class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = process(n);
        
        while (slow != fast) {
            slow = process(slow);
            fast = process(process(fast));
        }

        return slow == 1;
    }
    private int process(int n) {
        int newNum = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            newNum = newNum + lastDigit * lastDigit;
            n = n / 10;
        }
        return newNum;
    }
}