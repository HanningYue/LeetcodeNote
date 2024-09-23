class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (time(piles, mid) > h) {
                left = mid + 1;
            } else if (time(piles, mid) <= h) {
                right = mid;
            }
        }
        return right;
    }
    private int time(int[] piles, int speed) {
        int hour = 0;
        for (int pile : piles) {
            hour += pile / speed;
            if (pile % speed != 0) {
                hour++;
            }
        }
        return hour;
    }
}