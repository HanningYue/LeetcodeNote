class Solution {
    public int findLongestChain(int[][] pairs) {
        int maxLength = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int current = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > current) {
                current = pair[1];
                maxLength++;
            }
        }
        return maxLength;
    }
}