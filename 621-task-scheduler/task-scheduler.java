class Pair {
    int frequency, time;
    public Pair(int frequency, int time) {
        this.frequency = frequency;
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

        int minimumIntervals = 0;
        Queue<Pair> queue = new LinkedList<>();
        while (!queue.isEmpty() || !heap.isEmpty()) {
            minimumIntervals++;
            if (!heap.isEmpty()) {
                int currentMax = heap.poll();
                currentMax--;
                if (currentMax > 0) {
                    queue.offer(new Pair(currentMax, minimumIntervals + n));
                }
            }

            if (!queue.isEmpty()) {
                if (queue.peek().time == minimumIntervals) {
                    heap.offer(queue.poll().frequency);
                }
            }
        }
        return minimumIntervals;
    }
}