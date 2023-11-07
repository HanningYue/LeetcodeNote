/**
两边互相add的解法
MAXHEAP add， Queue add. REMEMBER TO DECLEAR maxHeap!
Queue -> save task and coolingtime <Pair>
PriorityQueue -> save maximum frequency
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
        
        int[] frequencyArr = new int[26];
        for (char task : tasks) {
            frequencyArr[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); //{frequency}
        for (int frequency : frequencyArr) {
            if (frequency > 0) {
                maxHeap.offer(frequency);
            }
        }
        
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>(); //{Pair<Frequency, time + cooling time>}
        
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int mostFrequency = maxHeap.poll();
                mostFrequency--;
                if (mostFrequency > 0) {
                    queue.offer(new Pair(mostFrequency, time + n));
                }
            }
            if (!queue.isEmpty()) {
                if (queue.peek().getValue() == time) {
                    maxHeap.offer(queue.poll().getKey());
                }
            }
        }
        return time;
    }
}