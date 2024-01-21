class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] one = firstList[i], two = secondList[j];
            if (one[1] >= two[0] && one[0] <= two[1]) {
                int start = Math.max(one[0], two[0]);
                int end = Math.min(one[1], two[1]);
                result.add(new int[]{start, end});
            }
            if (one[1] < two[1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}