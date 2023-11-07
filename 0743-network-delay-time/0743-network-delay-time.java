/**
Refer to question 787
The question is 1-indexed, "a network of n nodes, labeled from 1 to n" This applies to target - 1 and source - 1
判定条件相同 ==Integer.MAX_VALUE, SKIP 我们要找到source node
结果的 for loop 需要检查 是否有node unreachable 如果有 -1， 如果没有 update result，因为我们想要 minimum time，traverse whole paths
1. The source code is K
2. 我们需要把所有的node都走完 所以for loop < n
3. 在最后 for i=0，i<n, 只有n-1条边 n-1个edge
*/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delay = new int[n];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[k - 1] = 0;
        
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            temp = Arrays.copyOf(delay, delay.length);
            
            for (int j = 0; j < times.length; j++) {
                int source = times[j][0];
                int target = times[j][1];
                int cost = times[j][2];

                if (delay[source - 1] == Integer.MAX_VALUE) continue;
                
                if (delay[source - 1] + cost < temp[target - 1]) {
                    temp[target - 1] = delay[source - 1] + cost;
                }
                delay = temp;
            }
            
        }
        int minimumTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (delay[i] == Integer.MAX_VALUE) {
                return -1;
            }
            minimumTime = Math.max(minimumTime, delay[i]);
        }
        return minimumTime;
    }
}