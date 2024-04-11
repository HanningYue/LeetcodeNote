class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visitedNode = new HashSet<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        heap.offer(new int[]{0, 0});
        
        int result = 0;        
        while (visitedNode.size() < points.length) {
            int[] currentNode = heap.poll();
            int currentIndex = currentNode[0];
            int currentWeight = currentNode[1];

            if (visitedNode.contains(currentIndex)) {
                continue;
            }
            visitedNode.add(currentIndex);
            result += currentWeight;

            for (int i = 0; i < points.length; i++) {
                if (visitedNode.contains(i)) {
                    continue;
                }

                int nextWeight = Math.abs(points[i][0] - points[currentIndex][0])
                                +Math.abs(points[i][1] - points[currentIndex][1]);
                int[] nextNode = new int[]{i, nextWeight};
                heap.offer(nextNode);
            }
        }
        return result;
    }
}