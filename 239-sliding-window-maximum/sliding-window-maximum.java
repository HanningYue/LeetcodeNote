class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>(); //Save index only
        int[] result = new int[nums.length - k + 1];

        int windowRight = 0;
        while (windowRight < nums.length) {
            while (!deque.isEmpty() && nums[windowRight] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(windowRight);
            if (windowRight - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }
            if (windowRight - k + 1 >= 0) {
                result[windowRight - k + 1] = nums[deque.peekFirst()];
            }
            windowRight++;
        }
        return result;
    }
}