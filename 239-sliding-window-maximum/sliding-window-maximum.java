class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] == nums[b] 
        ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]);

        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());
        int[] result = new int[nums.length - k + 1];
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            maxSet.add(fast);
            
            if (fast - slow + 1 > k) {
                maxSet.remove(slow);
                slow++;
            }
            
            if (fast - slow + 1 == k) {
                result[slow] = nums[maxSet.first()];
            }
            fast++;
        }
        return result;
    }
}