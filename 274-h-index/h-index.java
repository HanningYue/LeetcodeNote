class Solution {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        int atMost = citations.length;

        for (int cit : citations) {
            if (cit >= atMost) {
                map.put(atMost, map.getOrDefault(atMost, 0) + 1);
            } else {
                map.put(cit, map.getOrDefault(cit, 0) + 1);
            }
        }

        int freq = 0;
        for (int i = atMost; i >= 0; i--) {
            freq += map.getOrDefault(i, 0);
            if (freq >= i) {
                return i;
            }
        }
        return -1;
    }
}