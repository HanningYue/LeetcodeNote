/**
To be true, 合适的triplets里面 3个element必须小于等于 target triplets 里3个element
如果有任意一个element大于，不合适
1. 先查看boolean greater
2. 如果greater，跳过当前triplet
3. 查看每一个element是否相等
    如果相等 result当前index mark true
返回result三个index都为true的情况
*/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[3];
        for (int[] triplet : triplets) {
            boolean greater = false;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    greater = true;
                    break;
                }
            }
            if (greater) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    result[i] = true;
                }
            }
        }
        return result[0] && result[1] && result[2];
    }
}