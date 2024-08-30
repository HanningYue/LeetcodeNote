class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() >= 2) {
            int heaviestOne = heap.poll();
            int heaviestTwo = heap.poll();
            
            if (heaviestOne == heaviestTwo) {
                continue;
            } else {
                heap.offer(heaviestOne - heaviestTwo);
            }
        }
        return heap.size() == 0 ? 0 : heap.poll();
    }
}