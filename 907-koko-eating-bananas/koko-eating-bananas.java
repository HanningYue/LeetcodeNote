class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int speed = left + (right - left) / 2;
            long time = calculateHours(piles, speed);
            if (time > h) {
                left = speed + 1; //Eat faster
            } else if (time < h) {
                right = speed - 1; //Eat slower
            } else if (time == h) {
                right = speed - 1; //Eat slower
            }
        }
        return left;
    }
    private long calculateHours(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed > 0) {
                hours++;
            }
        }
        return hours;
    }
}