/**
1. x is weight capacity, lease amount to ship each day is the heaviest weight, most amount is the sum of all
2. fx is the time needed, the more we load each day, the smaller fx is
3. want to find the smallest fx when days are fixed
*/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (solveFX(weights, mid) == days) {
                right = mid - 1;
            } else if (solveFX(weights, mid) > days) {
                left = mid + 1;
            } else if (solveFX(weights, mid) < days) {
                right = mid - 1;
            }
        }
        return left;
    }
    private int solveFX(int[] weights, int capacity) {
        int day = 0;
        for (int i = 0; i < weights.length;) {
            int eachDayCap = capacity;
            while (i < weights.length) {
                if (eachDayCap < weights[i]) {
                    break;
                }
                eachDayCap -= weights[i];
                i++;
            }
            day++;
        }
        return day;
    }
}
