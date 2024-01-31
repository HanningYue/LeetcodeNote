class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateDays(weights, mid) < days) {
                right = mid - 1;
            } else if (calculateDays(weights, mid) > days) {
                left = mid + 1;
            } else if (calculateDays(weights, mid) == days) {
                right = mid - 1;
            }
        }
        return left;
    }
    private int calculateDays(int[] weights, int capacity) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            int cap = capacity;
            while (i < weights.length) {
                if (weights[i] > cap) {
                    break;
                }
                cap -= weights[i];
                i++;                
            }
            days++;
        }
        return days;
    }
}