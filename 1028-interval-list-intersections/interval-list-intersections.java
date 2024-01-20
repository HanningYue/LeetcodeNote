class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int firstStart = first[0], firstEnd = first[1];
            int[] second = secondList[j];
            int secondStart = second[0], secondEnd = second[1];
            if (firstStart <= secondEnd && firstEnd >= secondStart) {
                int newStart = Math.max(firstStart, secondStart);
                int newEnd = Math.min(firstEnd, secondEnd);
                result.add(new int[]{newStart, newEnd});
            }
            if (firstEnd < secondEnd) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}