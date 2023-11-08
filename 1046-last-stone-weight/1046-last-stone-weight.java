/*
1. Create PriorityQueue maxHeap, to save all the stones weight
    Exit Condition : while (!maxHeap.isEmpty())
2. Declear two stones, stone1 and stone2 (stone1 pop first, is heavier)
    Compare two stone, if equal, pop both // if x != y, declear stone 3 equal stone1 - stone2
3. Add condition loop (if maxHeap.size() > 1)
4. Return the remaining stone or 0
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() > 1) {
                int stone1 = maxHeap.poll();
                int stone2 = maxHeap.poll();
                if (stone1 != stone2) {
                    int stone3 = stone1 - stone2;
                    maxHeap.offer(stone3);
                }
            }
            if (maxHeap.size() == 1) {
                return maxHeap.poll();
            }
        }
        return 0;
    }
}