class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] 
        ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> minSet = new TreeSet<>(comparator);
        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());       

        double[] result = new double[nums.length - k + 1];
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (fast - slow + 1 > k) {
                if (!maxSet.remove(slow)) {
                    minSet.remove(slow);
                }
                slow++;
            }
            if (minSet.size() <= maxSet.size()) {
                maxSet.add(fast);
                minSet.add(maxSet.pollFirst());
            } else {
                minSet.add(fast);
                maxSet.add(minSet.pollFirst());
            }
            if (fast - slow + 1 == k) {
                result[slow] = k % 2 == 0 ? 
                ((double) nums[maxSet.first()] + nums[minSet.first()]) / 2.0 
                : nums[minSet.first()];
            }
            fast++;
        }
        return result;
    }
}