class Pair {
    int value;
    int arrayNum;
    int index;
    public Pair(int value, int arrayNum, int index) {
        this.value = value;
        this.arrayNum = arrayNum;
        this.index = index;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int intervalLeft = Integer.MAX_VALUE, intervalRight = Integer.MIN_VALUE;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < nums.size(); i++) {
            intervalRight = Math.max(intervalRight, nums.get(i).get(0));
            minHeap.offer(new Pair(nums.get(i).get(0), i, 0));
        }

        int resultLeft = 0, resultRight = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {
            Pair current = minHeap.poll();
            int value = current.value, arrayNum = current.arrayNum, index = current.index;
            intervalLeft = value;

            if (intervalRight - intervalLeft < resultRight - resultLeft) {
                resultRight = intervalRight;
                resultLeft = intervalLeft;
            }
            
            if (index + 1 < nums.get(arrayNum).size()) {
                Pair nextPair = new Pair(nums.get(arrayNum).get(index + 1), arrayNum, index + 1);
                minHeap.offer(nextPair);
                intervalRight = Math.max(intervalRight, nextPair.value);
            }
        }

        return new int[]{resultLeft, resultRight};
    }
}