class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int[] odd = beautifulArray((n + 1) / 2);
        int[] even = beautifulArray(n / 2);
        int[] merge = new int[n];
        for (int i = 0; i < odd.length; i++) {
            merge[i] = 2 * odd[i] - 1;
        }
        for (int i = 0; i < even.length; i++) {
            merge[odd.length + i] = 2 * even[i];
        }
        return merge;
    }
}