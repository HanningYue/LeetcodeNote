/**
Refer to question 787

*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            temp = Arrays.copyOf(paths, paths.length);
            
            for (int j = 0; j < times.length; j++) {
                int source = times[j][0];
                int target = times[j][1];
                int time = times[j][2];

                if (temp[source - 1] != Integer.MAX_VALUE && temp[source - 1] + time < temp[target - 1]) 
                {
                    temp[target - 1] = temp[source - 1] + time;
                }
            }
            paths = temp;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                return -1; //There are node are unreachable
            }
            result = Math.max(result, paths[i]); //The result node is the most costly to receive the signal
        }

        return result;
    }
}