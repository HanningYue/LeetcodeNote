class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int banana : piles) {
            right = Math.max(right, banana);
        }
        while (left < right) {
            int speed = left + (right - left) / 2;
            int totalHours = findHours(piles, speed);
            if (totalHours > h) {
                left = speed + 1;
            } else if (totalHours <= h) {
                right = speed;
            }
        }
        return right;
    }
    private int findHours(int[] bananas, int speed) {
        int hours = 0;
        for (int banana : bananas) {
            hours += banana / speed;
            if (banana % speed != 0) {
                hours++;
            }
        }
        return hours;
    }
}