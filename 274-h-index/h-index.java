class Solution {
    public int hIndex(int[] citations) {
        int maxH = citations.length;
        Map<Integer, Integer> map = new HashMap<>(); //Hold number of citation and frequency
        for (int citation : citations) {
            if (citation >= maxH) {
                map.put(maxH, map.getOrDefault(maxH, 0) + 1);
            } else if (citation < maxH) {
                map.put(citation, map.getOrDefault(citation, 0) + 1);
            }
        }

        int frequency = 0;
        for (int atMostCitation = maxH; atMostCitation >= 0; atMostCitation--) {
            frequency += map.getOrDefault(atMostCitation, 0);
            if (frequency >= atMostCitation) {
                return atMostCitation;
            }
        }
        return -1;
    }
}