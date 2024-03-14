class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[3];
        for (int[] triplet : triplets) {
            boolean greaterElement = false;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    greaterElement = true;
                    break;
                }
            }
            
            if (greaterElement) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    result[i] = true;
                }
            }
        }
        for (boolean val : result) {
            if (!val) {
                return false;
            }
        }
        return true;
    }
}