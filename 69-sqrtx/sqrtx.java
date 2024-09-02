class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        int left = 0, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long)mid * mid;
            if (product == x) {
                return mid;
            } else if (product < x) {
                left = mid + 1;
            } else if (product > x) {
                right = mid - 1;
            }
        }
        return right;
    }
}