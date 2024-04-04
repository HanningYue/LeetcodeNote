class Solution {
    public int jump(int[] nums) {
        int currentFurthest = 0;
        int subFurthest = 0, step = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            currentFurthest = Math.max(currentFurthest, i + nums[i]);
            if (i == subFurthest) {
                step++;
                subFurthest = currentFurthest;
            }
        }

        return step;
    }
}