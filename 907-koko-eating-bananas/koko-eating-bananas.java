class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 1;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
    
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (function(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int function(int[] piles, int rate) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / rate;
            if (piles[i] % rate > 0) {
                hours++;
            }
        }
        return hours;
    }
}