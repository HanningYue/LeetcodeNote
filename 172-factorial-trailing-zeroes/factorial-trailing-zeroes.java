class Solution {
    public int trailingZeroes(int n) {
        int factor = 5;
        int numberOfFactor = 0;

        while (factor <= n) {
            int currentNumberOfFactor = n / factor;
            numberOfFactor += currentNumberOfFactor;
            factor = factor * 5;
        }
        return numberOfFactor;
    }
}