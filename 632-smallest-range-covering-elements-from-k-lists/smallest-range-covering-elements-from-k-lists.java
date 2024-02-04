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
        int resultRight = Integer.MAX_VALUE, resultLeft = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int currentRight = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Pair(nums.get(i).get(0), i, 0));
            currentRight = Math.max(currentRight, nums.get(i).get(0));
        }

        int currentLeft;
        while (minHeap.size() == nums.size()) {
            Pair current = minHeap.poll();
            int value = current.value;
            int arrayNum = current.arrayNum;
            int index = current.index;
            
            currentLeft = value;    
            if (currentRight - currentLeft < resultRight - resultLeft) {
                resultRight = currentRight;
                resultLeft = currentLeft;
            }

            if (index + 1 < nums.get(arrayNum).size()) {
                minHeap.offer(new Pair(nums.get(arrayNum).get(index + 1), arrayNum, index + 1));
                currentRight = Math.max(currentRight, nums.get(arrayNum).get(index + 1));
            }
        }
        return new int[]{resultLeft, resultRight};
    }
}