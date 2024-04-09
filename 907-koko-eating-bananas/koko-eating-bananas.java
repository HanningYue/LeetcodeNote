class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = totalHours(piles, mid);
            if (hours > h) {
                left = mid + 1;
            } else if (hours <= h) {
                right = mid;
            }
        }
        return left;
    }
    private int totalHours(int[] piles, int rate) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / rate;
            if (pile % rate != 0) {
                hours++;
            }
        }
        return hours;
    }
}
