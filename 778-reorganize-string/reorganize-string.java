class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap 
        = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> previous = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);

            if (previous != null && previous.getValue() > 0) {
                maxHeap.offer(previous);
            }
            previous = current;
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}