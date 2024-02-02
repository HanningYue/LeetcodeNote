class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        maxHeap.addAll(map.values());

        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int mostFreq = maxHeap.poll();
                mostFreq--;
                if (mostFreq > 0) {
                    queue.offer(new Pair(mostFreq, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().getValue() == time) {
                maxHeap.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}