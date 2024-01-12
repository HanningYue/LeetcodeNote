class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int[] result = new int[n];
        int[] odd = beautifulArray((n + 1) / 2);
        int[] even = beautifulArray(n / 2);
        for (int i = 0; i < odd.length; i++) {
            result[i] = odd[i] * 2 - 1;
        }
        for (int i = 0; i < even.length; i++) {
            result[i + odd.length] = even[i] * 2;
        }
        return result;
    }
}