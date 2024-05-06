class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[3];
        
        for (int[] triplet : triplets) {
            boolean greater = false;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    greater = true;
                    break;
                }
            }
            if (greater) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    result[i] = true;
                }
            }
        }
        for (boolean value : result) {
            if (!value) {
                return false;
            }
        }
        return true;
    }
}