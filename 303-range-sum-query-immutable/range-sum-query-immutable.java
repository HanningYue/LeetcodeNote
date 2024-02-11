class NumArray {
    int[] presum;
    public NumArray(int[] nums) {
        presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 1; i < presum.length; i++) {
            presum[i] = nums[i - 1] + presum[i - 1];
        }
    }
    public int sumRange(int left, int right) {
        return presum[right + 1] - presum[left];        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */