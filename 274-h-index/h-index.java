class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                count[n]++;
            } else {
                count[citation]++;
            }
        }

        int totalPaper = 0;
        for (int i = n; i >= 0; i--) {
            totalPaper += count[i];
            if (totalPaper >= i) {
                return i;
            }
        }
        return 0;
    }
}