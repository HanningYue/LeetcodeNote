class Pair {
    int value;
    int arrayNum;
    int index;
    public Pair(int value, int arrayNum, int index) {
        this.value = value;
        this.index = index;
        this.arrayNum = arrayNum;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> a.value - b.value);
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new Pair(matrix[i][0], i, 0));
        }
        
        int arrayNum = 0, index = 0, value = 0;
        while (!minHeap.isEmpty() && k > 0) {
            Pair current = minHeap.poll();
            arrayNum = current.arrayNum;
            index = current.index;
            
            if (index + 1 < matrix[arrayNum].length) {
                minHeap.offer(new Pair(matrix[arrayNum][index + 1], arrayNum, index + 1));
            }
            k--;
        }
        return matrix[arrayNum][index];
    }
}