class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean direction = nums[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = nextStart(nums, slow, direction);
                fast = nextStart(nums, fast, direction);
                if (fast != -1)
                    fast = nextStart(nums, fast, direction);
            } while (fast != slow && fast != -1 && slow != -1);
            if (slow == fast && slow != -1) {
                return true;
            }
        }
        return false;
    }
    private int nextStart(int[] nums, int currentIdx, boolean direction) {
        boolean currentDir = nums[currentIdx] >= 0;
        if (direction != currentDir)
            return -1;
        int nextIdx = (nums[currentIdx] + currentIdx) % nums.length;
        if (nextIdx < 0) 
            nextIdx += nums.length;
        if (nextIdx == currentIdx)
            return -1;
        return nextIdx;
    }
}