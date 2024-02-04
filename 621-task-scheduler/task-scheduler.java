class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(map.values());

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int mostFreq = maxHeap.poll();
                mostFreq--;
                if (mostFreq > 0) {
                    queue.offer(new int[]{mostFreq, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}