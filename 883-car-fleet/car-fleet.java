class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // 按照初始位置，从小到大排序
        Arrays.sort(cars, (int[] a, int[] b) -> {
            return Integer.compare(a[0], b[0]);
        });
        // 计算每辆车到达终点的时间
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            int[] car = cars[i];
            time[i] = (double) (target - car[0]) / car[1];
        }

        //使用单调栈计算车队的数量
        Stack<Double> stk = new Stack<>();
        for (double t : time) {
            while (!stk.isEmpty() && t >= stk.peek()) {
                stk.pop();
            }
            stk.push(t);
        }
        return stk.size();
    }
}