class Solution {
    public List<Integer> findClosestElements(int[] nums, int distance, int target) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() { // {value, diff}
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - target);
            minHeap.offer(new int[]{nums[i], diff});
        }

        while (!minHeap.isEmpty() && distance > 0) {
            result.add(minHeap.poll()[0]);
            distance--;
        }
        Collections.sort(result);
        return result;
    }
}