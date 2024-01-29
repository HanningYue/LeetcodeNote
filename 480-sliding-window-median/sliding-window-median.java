class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] 
        ? Integer.compare(nums[a], nums[b]) : a - b;

        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> minSet = new TreeSet<>(comparator);

        double[] result = new double[nums.length - k + 1];

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (fast - slow + 1 > k) {
                if (!maxSet.remove(slow)) {
                    minSet.remove(slow);
                }
                slow++;
            }

            if (maxSet.isEmpty() || nums[fast] < nums[maxSet.first()]) {
                maxSet.add(fast);
            } else {
                minSet.add(fast);
            }
            if (maxSet.size() > minSet.size() + 1) {
                minSet.add(maxSet.pollFirst());
            } else if (minSet.size() > maxSet.size()) {
                maxSet.add(minSet.pollFirst());
            }

            if (fast - slow + 1 == k) {
                result[slow] = k % 2 == 0 
                ? ((double)nums[maxSet.first()] + nums[minSet.first()]) / 2.0
                : nums[maxSet.first()];
            }
            fast++;
        }
        return result;
    }
}