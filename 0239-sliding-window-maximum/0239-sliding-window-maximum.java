/*
We use an monotonic deque to solve the problem, the deque will store index
需要用一个保存maximum的单调栈(存index) 每一次对比进来的数字和末尾的数字
用单调栈保持一个window的size (fast - slow), 如果当前超出了window size (fast - slow) 去掉头部的index
如果当前刚好等于window size (fast - slow + 1) 加入头部的value到result
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            while (!dq.isEmpty() && i - k >= dq.peekFirst()) {
                dq.pollFirst();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}