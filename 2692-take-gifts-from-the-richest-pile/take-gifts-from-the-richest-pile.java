class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        long result = 0;
        for (int i = 0; i < k; i++) {
            int mostGift = maxHeap.poll();
            int leftGift = (int)Math.sqrt(mostGift);
            maxHeap.offer(leftGift);
        }
        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }
        return result;
    }
}