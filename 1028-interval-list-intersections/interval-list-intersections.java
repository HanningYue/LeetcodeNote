class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i], second = secondList[j];
            if (first[1] >= second[0] && first[0] <= second[1]) {
                int[] overlap = new int[2];
                overlap[0] = Math.max(first[0], second[0]);
                overlap[1] = Math.min(first[1], second[1]);
                result.add(overlap);
            }
            if (first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}