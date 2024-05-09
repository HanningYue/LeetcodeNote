class Solution {
    public int hIndex(int[] citations) {
        int maxH = citations.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int citation : citations) {
            if (citation >= maxH) {
                map.put(maxH, map.getOrDefault(maxH, 0) + 1);
            } else {
                map.put(citation, map.getOrDefault(citation, 0) + 1);
            }
        }

        int maxCited = 0;
        for (int i = maxH; i >= 0; i--) {
            if (map.containsKey(i)) {
                maxCited += map.get(i);
            }
            if (maxCited >= i) {
                return i;
            }
        }
        return -1;
    }
}