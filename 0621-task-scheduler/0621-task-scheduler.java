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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        
        char[] frequencyArr = new char[26];
        for (char task : tasks) {
            frequencyArr[task - 'A']++;
        }
        
        for (int frequency : frequencyArr) {
            if (frequency > 0) {
                maxHeap.offer(frequency);   
            }
        }
        
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int mostFrequent = maxHeap.poll();
                mostFrequent--;
                if (mostFrequent > 0) {
                    queue.add(new Pair<Integer, Integer>(mostFrequent, time + n));
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