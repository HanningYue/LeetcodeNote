class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] one = firstList[i], two = secondList[j];
            if (one[1] >= two[0] && one[0] <= two[1]) {
                int[] newInterval = new int[2];
                newInterval[0] = Math.max(one[0], two[0]);
                newInterval[1] = Math.min(one[1], two[1]);
                result.add(newInterval);
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