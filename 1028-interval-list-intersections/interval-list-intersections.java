class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] firstInterval = firstList[i], secondInterval = secondList[j];
            if (firstInterval[1] >= secondInterval[0] 
            && firstInterval[0] <= secondInterval[1]) {
                int newStart = Math.max(firstInterval[0], secondInterval[0]);
                int newEnd = Math.min(firstInterval[1], secondInterval[1]);
                result.add(new int[]{newStart, newEnd});
            }
            if (firstInterval[1] < secondInterval[1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}