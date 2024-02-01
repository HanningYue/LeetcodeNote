class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int absDiff = Math.abs(nums[i] - x);
            minHeap.offer(new int[]{absDiff, nums[i]});
        }
        while (!minHeap.isEmpty() && k > 0) {
            result.add(minHeap.poll()[1]);
            k--;
        }
        Collections.sort(result);
        return result;
    }
}