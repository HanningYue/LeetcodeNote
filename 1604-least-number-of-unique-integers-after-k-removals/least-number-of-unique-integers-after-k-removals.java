class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap 
        = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        minHeap.addAll(map.entrySet());

        while (!minHeap.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> current = minHeap.peek();
            current.setValue(current.getValue() - 1);
            if (current.getValue() == 0) {
                minHeap.poll();
            }
            k--;
        }
        return minHeap.size();
    }
}