class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = findNext(nums, i);
            while (nums[slow] * nums[fast] > 0) {
                if (slow == fast) {
                    if (slow == findNext(nums, slow)) {
                        break;
                    }
                    return true;
                }
                if (nums[fast] * nums[findNext(nums, fast)] < 0) {
                    break;
                }
                slow = findNext(nums, slow);
                fast = findNext(nums, findNext(nums, fast));
            }
        }
        return false;
    }
    private int findNext(int[] nums, int currentIdx) {
        int nextIdx = (currentIdx + nums[currentIdx]) % nums.length;
        if (nextIdx >= 0) {
            return nextIdx;
        } else {
            return nextIdx + nums.length;
        }
    }
}