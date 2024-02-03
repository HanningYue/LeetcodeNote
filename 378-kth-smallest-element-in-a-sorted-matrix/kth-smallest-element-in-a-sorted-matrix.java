class Pair {
    int value;
    int index;
    int arrayNum;
    public Pair(int value, int index, int arrayNum) {
        this.value = value;
        this.index = index;
        this.arrayNum = arrayNum;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> a.value - b.value);
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new Pair(matrix[i][0], 0, i));
        }
        int index = 0, arrayNum = 0;
        while (!minHeap.isEmpty() && k > 0) {
            Pair current = minHeap.poll();
            index = current.index;
            arrayNum = current.arrayNum;
            
            if (index + 1 < matrix.length) {
                minHeap.offer(new Pair(matrix[arrayNum][index + 1], index + 1, arrayNum));
            }
            k--;
        }
        return matrix[arrayNum][index];
    }
}