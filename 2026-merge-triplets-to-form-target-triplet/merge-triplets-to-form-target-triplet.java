class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] mark = new boolean[target.length];

        for (int[] triplet : triplets) {
            boolean greater = false;
            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] > target[i]) {
                    greater = true;
                    break;
                }
            }
            if (greater) {
                continue;
            }

            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] == target[i]) {
                    mark[i] = true;
                }
            }
        }

        for (boolean val : mark) {
            if (!val) {
                return false;
            }
        }
        return true;
    }
}