class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean forward = nums[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = findNext(nums, forward, slow);
                fast = findNext(nums, forward, fast);
                if (fast != -1)
                    fast = findNext(nums, forward, fast);
            } while (slow != -1 && fast != -1 && slow != fast);
            if (slow != -1 && slow == fast) 
                return true;
        }
        return false;
    }
    private int findNext(int[] nums, boolean forward, int currentIdx) {
        boolean direction = nums[currentIdx] >= 0;
        if (direction != forward) 
            return -1;
        int nextIdx = (nums[currentIdx] + currentIdx) % nums.length;
        if (nextIdx < 0) 
            nextIdx += nums.length;
        if (nextIdx == currentIdx)
            return -1;
        return nextIdx;
    }
}