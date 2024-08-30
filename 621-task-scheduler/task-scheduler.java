class Pair {
    int frequency;
    int time;
    public Pair(int frequency, int time) {
        this.frequency = frequency;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });        

        int[] frequencyArray = new int[26];
        for (char task : tasks) {
            frequencyArray[task - 'A']++;
        }
        for (int freq : frequencyArray) {
            if (freq > 0) {
                heap.offer(freq);
            }
        }

        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        while (!heap.isEmpty() || !queue.isEmpty()) {
            result++;

            if (!heap.isEmpty()) {
                int currentMaxFrequency = heap.poll();
                currentMaxFrequency--;
                if (currentMaxFrequency > 0) {
                    queue.offer(new Pair(currentMaxFrequency, result + n));                   
                }
            }

            if (!queue.isEmpty() && result == queue.peek().time) {
                heap.offer(queue.poll().frequency);
            }
        }
        return result;
    }
}