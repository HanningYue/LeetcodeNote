class Pair {
    int key, value;
    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if ((b.key - a.key) == 0) {
                    return b.value - a.value;
                }
                return b.key - a.key;
            }
        });

        for (int num : nums) {
            heap.offer(new Pair(Math.abs(num - x), num));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (heap.size() != 0) {
            Pair p = heap.poll();
            result.add(p.value);
        }
        Collections.sort(result);
        return result;
    }
}