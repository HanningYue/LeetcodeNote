class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            int currentPos = cars[i][0];
            int currentSpeed = cars[i][1];
            double timeToDes = (double)(target - currentPos) / currentSpeed;
            time[i] = timeToDes;
        }

        Stack<Double> stack = new Stack<>();
        for (double currentTime : time) {
            while (!stack.isEmpty() && currentTime >= stack.peek()) {
                stack.pop();
            }
            stack.push(currentTime);
        }
        return stack.size();
    }
}