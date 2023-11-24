/**
We need to check greater condition first, because if it is greater, we can break and check 
next number. In the second iteration, if greater, we skip the number because already 
checked. Finally, we check the equal condition, return result[] which 3 indices are 
all marked true
*/
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
            
            if (greater) continue;
            
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    result[i] = true;
                }
            }
        }
        return result[0] && result[1] && result[2];
    }
}