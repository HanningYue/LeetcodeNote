class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] one = firstList[i];
            int oneStart = one[0], oneEnd = one[1];
            int[] two = secondList[j];
            int twoStart = two[0], twoEnd = two[1];
            if (oneEnd >= twoStart && oneStart <= twoEnd) {
                int start = Math.max(oneStart, twoStart);
                int end = Math.min(oneEnd, twoEnd);
                result.add(new int[]{start, end});
            }
            if (oneEnd < twoEnd) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}