class Solution {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        int most = citations.length;
        for (int i = 0; i < citations.length; i++) {
            int currentCitation = citations[i];
            if (currentCitation >= most) {
                map.put(most, map.getOrDefault(most, 0) + 1);
            } else {
                map.put(currentCitation, map.getOrDefault(currentCitation, 0) + 1);
            }
        }
        int totalCitation = 0;
        for (int i = most; i >= 0; i--) {
            totalCitation += map.getOrDefault(i, 0);
            if (totalCitation >= i) {
                return i;
            }
        }
        return 0;
    }
}