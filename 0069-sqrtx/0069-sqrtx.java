class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 2, high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long target = (long) mid * mid;
            
            if (target > x) {
                high = mid - 1;
            } else if (target < x) {
                low = mid + 1;
            } else if (target == x) {
                return mid;
            }
        }
        return high;
    }
}