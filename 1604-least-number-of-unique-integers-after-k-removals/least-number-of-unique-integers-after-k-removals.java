class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap
        = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        minHeap.addAll(map.entrySet());

        while (!minHeap.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> current = minHeap.poll();
            current.setValue(current.getValue() - 1);    
            if (current.getValue() > 0){
                minHeap.offer(current);
            }
            k--;
        }
        return minHeap.size();
    }
}