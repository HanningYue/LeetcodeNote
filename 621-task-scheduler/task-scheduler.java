class Pair {
    int frequency;
    int timeStamp;
    public Pair(int frequency, int timeStamp) {
        this.frequency = frequency;
        this.timeStamp = timeStamp;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> frequencyHeap = new PriorityQueue<>(new Comparator<Integer>() {
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
                frequencyHeap.offer(freq);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        int result = 0;
        while (!queue.isEmpty() || !frequencyHeap.isEmpty()) {
            result++;
            if (!frequencyHeap.isEmpty()) {
                int maxFreq = frequencyHeap.poll();
                maxFreq--;
                if (maxFreq > 0) {
                    queue.offer(new Pair(maxFreq, result + n));
                }
            }

            if (!queue.isEmpty() && result == queue.peek().timeStamp) {
                frequencyHeap.offer(queue.poll().frequency);
            }
        }
        
        return result;
    }
}