class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int banana : piles) {
            right = Math.max(right, banana);
        }
        while (left < right) {
            int speed = left + (right - left) / 2;
            int hours = findHours(piles, speed);
            if (hours > h) {
                left = speed + 1;
            } else {
                right = speed;
            }
        }
        return right;
    }
    private int findHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed != 0) {
                hours++;
            }
        }
        return hours;
    }
}