class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean direction = nums[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = nextIdx(nums, direction, slow);
                fast = nextIdx(nums, direction, fast);
                if (fast != -1)
                    fast = nextIdx(nums, direction, fast);
            } while (slow != fast && slow != -1 && fast != -1);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }
    private int nextIdx(int[] nums, boolean direction, int currentIdx) {
        boolean nextDirection = nums[currentIdx] >= 0;
        if (nextDirection != direction)
            return -1;
        int nextStart = (nums[currentIdx] + currentIdx) % nums.length;
        if (nextStart < 0)
            nextStart += nums.length;
        if (nextStart == currentIdx)
            return -1;
        return nextStart;
    }
}