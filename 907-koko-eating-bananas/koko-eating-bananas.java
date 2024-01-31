class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int speed = left + (right - left) / 2;
            double time = 0.0;
            for (int pile : piles) {
                time += Math.ceil((double)pile / speed);
            }

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
}