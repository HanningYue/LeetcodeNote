class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(b[0], a[0]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int absDiff = Math.abs(nums[i] - x);
            maxHeap.offer(new int[]{absDiff, nums[i]});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }
        Collections.sort(result);
        return result;
    }
}