class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size() >= 2) {
            int stoneOne = heap.poll();
            int stoneTwo = heap.poll();
            if (stoneOne == stoneTwo) {
                continue;
            } else {
                heap.offer(Math.abs(stoneOne - stoneTwo));
            }
        }
        if (heap.size() == 0) {
            return 0;
        }
        return heap.poll();
    }
}