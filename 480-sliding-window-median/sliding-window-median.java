class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] == nums[b] 
        ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]);

        //Index
        TreeSet<Integer> minSet = new TreeSet<>(comparator);
        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());

        double[] result = new double[nums.length - k + 1];
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (fast - slow + 1 > k) {
                if (!minSet.remove(slow)) {
                    maxSet.remove(slow);
                }
                slow++;
            }

            if (maxSet.isEmpty() || nums[maxSet.first()] > nums[fast]) {
                maxSet.add(fast);
            } else {
                minSet.add(fast);
            }

            if (maxSet.size() > minSet.size() + 1) {
                minSet.add(maxSet.pollFirst());
            } else if (maxSet.size() < minSet.size()) {
                maxSet.add(minSet.pollFirst());
            }

            if (fast - slow + 1 == k) {
                result[slow] = (k % 2 == 0)
                ? ((double)nums[maxSet.first()] + nums[minSet.first()]) / 2.0
                : nums[maxSet.first()];
            }
            fast++;
        }
        return result;
    }
}