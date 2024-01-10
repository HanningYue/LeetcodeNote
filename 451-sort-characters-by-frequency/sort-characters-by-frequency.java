class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap 
            = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> mostFreq = maxHeap.poll();
            for (int i = 0; i < mostFreq.getValue(); i++) {
                sb.append(mostFreq.getKey());
            }
        }
        return sb.toString();
    }
}