class Car {
    int position;
    int speed;
    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Car(position[i], speed[i]));
        }
        Collections.sort(list, (a, b) -> a.position - b.position);

        List<Double> time = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            int distanceToTarget = target - list.get(i).position;
            int currentSpeed = list.get(i).speed;
            double timeToReach = (double)distanceToTarget / currentSpeed;
            time.add(timeToReach);
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