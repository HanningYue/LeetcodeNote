class Pair {
    int position;
    int speed;
    public Pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<Pair>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            list.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.position - b.position;
            }
        });

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            Pair furthest = list.get(i);
            time[i] = (double) (target - furthest.position) / furthest.speed;
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double currentTime = time[i];
            while (!stack.isEmpty() && currentTime >= stack.peek()) {
                stack.pop();
            }
            stack.push(currentTime);
        }
        return stack.size();
    }
}