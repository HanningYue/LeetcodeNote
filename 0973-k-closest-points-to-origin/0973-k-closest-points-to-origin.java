/*
Want to return the closest point to origin, use maxHeap<int[]>
1. In maxHeap, write customizable comparator where the a[0]*a[0] + a[1]*a[1] and b[0]*b[0] + b[1]*b[1]
2. After comparison, fill maxHeap with int[]points, the maxHeap will sort them from greatest distance to smallest distance. After the maxHeap size exceeds k, pop. So the remaining are the K-th smallest.
3. Declear result[][], iterate k times, fill result[i] with maxHeap poll()
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
           }
        });
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}