class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        } 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (solveFX(piles, mid) == h) {
                right = mid - 1;
            } else if (solveFX(piles, mid) > h) {
                left = mid + 1;
            } else if (solveFX(piles, mid) < h) {
                right = mid - 1;
            }
        }
        return left;
    }
    private long solveFX(int[] piles, int speed) {
        long hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / speed;
            if (piles[i] % speed != 0) {
                hour++;
            }
        }
        return hour;
    }
}