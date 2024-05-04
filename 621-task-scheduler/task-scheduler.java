class Pair {
    int maxFreq;
    int time;
    public Pair(int maxFreq, int time) {
        this.maxFreq = maxFreq;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        
        int[] freqArray = new int[26];
        for (char task : tasks) {
            freqArray[task - 'A']++;
        }
        for (int freq : freqArray) {
            if (freq > 0) {
                heap.offer(freq);
            }
        }

        int currentTime = 0;
        Queue<Pair> queue = new LinkedList<>();
        while (!heap.isEmpty() || !queue.isEmpty()) {
            currentTime++;
            if (!heap.isEmpty()) {
                int maxFreq = heap.poll();
                maxFreq--;
                if (maxFreq > 0) {
                    queue.offer(new Pair(maxFreq, currentTime + n));
                }
            }
            if (!queue.isEmpty()) {
                if (queue.peek().time == currentTime) {
                    heap.offer(queue.poll().maxFreq);
                }
            }
        }
        return currentTime;
    }
}