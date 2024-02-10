class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length, hIndex = 0;
        int[] frequency = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length) {
                frequency[length]++;
            } else {
                frequency[citations[i]]++;
            }
        }
        for (int i = length; i >= 0; i--) {
            hIndex += frequency[i];
            if (hIndex >= i) {
                return i;
            }
        }
        return 0;
    }
}