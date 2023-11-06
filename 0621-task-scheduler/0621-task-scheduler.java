/**
两边互相add的解法
MAXHEAP add， Queue add. REMEMBER TO DECLEAR maxHeap!
We do not acctually care about the specific character, just their frequency
1. Since tasks[i] only contains upper-case English Letter, use array to save all letters frequency
2. Use maxHeap, save all the frequencies
3. We only add frequency to maxHeap if it is greater than 0, (If a character does not appear, ignore)
4. Increase time for each iteration
5. Decrease frequency by one, when adding to queue, check if decreased freuqnecy is > 0
6. If queue is not empty, and time is equal to the curren time, add back frequency to maxHeap
*/
class Solution {
   public int leastInterval(char[] tasks, int n) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
       Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int time = 0;

       int[] frequencyArr = new int[26];
        for (char task : tasks) {
            frequencyArr[task - 'A']++;
        }

        for (int frequency : frequencyArr) {
            if (frequency > 0) {
                maxHeap.offer(frequency);
            }
        }

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int maxFrequency = maxHeap.poll();
                maxFrequency--;
                if (maxFrequency > 0) {
                    queue.offer(new Pair(maxFrequency, time + n));
                }
            }

            if (!queue.isEmpty() && queue.peek().getValue() == time) {
                maxHeap.offer(queue.poll().getKey());                
            }
        }
        return time;
    }
}