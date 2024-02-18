class Solution {
    public int candy(int[] ratings) {
        int[] resultArr = new int[ratings.length];
        Arrays.fill(resultArr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                resultArr[i] = resultArr[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                resultArr[i] = Math.max(resultArr[i + 1] + 1, resultArr[i]);
            }
        }

        int result = 0;
        for (int num : resultArr) {
            result += num;
        }
        return result;
    }
}