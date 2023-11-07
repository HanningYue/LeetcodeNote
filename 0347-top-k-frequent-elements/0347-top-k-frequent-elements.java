/*
Return int[] // Map.entry<Integer, Integer> // entrySet()
We need to return the K most frequent elements
1. For each number, we need a relation to store {the number, their frequency}
2. Record number and their frequency to map
3. minHeap to save the ENTRY of our map, reason why we saving the ENTRY is because we need to return int[] of the number, but we need to compare their frequency. So we can use minHeap -> a.getValue() - b.getValue() /The property of Entry of map to directly compare their frequency
4. iterate every entry of the map.entrySet(), offer entry to minHeap, pop minHeap if size exceeds k, so the remaining of minHeap is guaranteed to be the Biggest frequency(we pop all the small frequency)
4. 
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //{number, frequency}
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap 
            = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
                                  
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
            
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;               
    }
}