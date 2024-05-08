class Solution {
    public int candy(int[] ratings) {
        int[] children = new int[ratings.length];
        Arrays.fill(children, 1);

        for (int i = 1; i < children.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                children[i] = children[i - 1] + 1;
            }
        }
        for (int i = children.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && children[i] <= children[i + 1]) {
                children[i] = children[i + 1] + 1;
            }
        }

        int result = 0;
        for (int candy : children) {
            result += candy;
        }
        return result;
    }
}