class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int banana : piles) {
            right = Math.max(right, banana);
        }
        while (left < right) {
            int speed = left + (right - left) / 2;
            int hours = hoursToEatAllBanana(piles, speed);
            if (hours > h) {
                left = speed + 1;
            } else if (hours <= h) {
                right = speed;
            }
        }
        return right;
    }
    private int hoursToEatAllBanana(int[] piles, int speed) {
        int hours = 0;
        for (int banana : piles) {
            hours += banana / speed;
            if (banana % speed != 0) {
                hours++;
            }
        }
        return hours;
    }
}