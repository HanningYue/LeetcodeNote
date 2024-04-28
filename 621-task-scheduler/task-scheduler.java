class Pair {
    int freq, time;
    public Pair(int freq, int time) {
        this.freq = freq;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Pair> queue = new LinkedList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        
        int[] freqArr = new int[26];
        for (char task : tasks) {
            freqArr[task - 'A']++;
        }
        for (int freq : freqArr) {
            if (freq > 0) {
                heap.offer(freq);
            }
        }

        int time = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                int maxFreq = heap.poll();
                maxFreq--;
                if (maxFreq > 0) {
                    queue.offer(new Pair(maxFreq, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().time == time) {
                heap.offer(queue.poll().freq);
            }
        }
        return time;
    }
}