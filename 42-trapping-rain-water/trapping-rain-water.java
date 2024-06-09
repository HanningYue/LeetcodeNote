class Pair {
    int index, height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Solution {
    public int trap(int[] height) {
        Stack<Pair> stack = new Stack<>();
        int waterTrapped = 0;

        for (int i = 0; i < height.length; i++) {
            int currentIndex = i, currentHeight = height[i];

            while (!stack.isEmpty() && stack.peek().height < currentHeight) {
                Pair top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                Pair left = stack.peek();
                int distance = currentIndex - left.index - 1;
                int boundedHeight = Math.min(left.height, currentHeight) - top.height;
                waterTrapped += distance * boundedHeight;
            }

            stack.push(new Pair(currentIndex, currentHeight));
        }

        return waterTrapped;
    }
}
