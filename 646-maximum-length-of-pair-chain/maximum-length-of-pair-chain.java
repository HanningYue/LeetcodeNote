class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int currentEnd = Integer.MIN_VALUE;
        int maxLength = 0;
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                maxLength++;
                currentEnd = pair[1];
            }
        }
        return maxLength;
    }
}