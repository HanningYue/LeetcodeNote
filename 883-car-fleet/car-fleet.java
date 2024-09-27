class State {
    int position, speed;
    public State(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<State> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            int currentPos = position[i];
            int currentSpeed = speed[i];
            list.add(new State(currentPos, currentSpeed));
        }
        Collections.sort(list, (a, b) -> a.position - b.position);

        List<Double> time = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int pos = target - list.get(i).position;
            int currentSpeed = list.get(i).speed;
            
            double currentTime = (double)pos / currentSpeed;
            time.add(currentTime);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < time.size(); i++) {
            double currentTime = time.get(i);
            while (!stack.isEmpty() && currentTime >= stack.peek()) {
                stack.pop();
            }
            stack.push(currentTime);
        }
        return stack.size();
    }
}