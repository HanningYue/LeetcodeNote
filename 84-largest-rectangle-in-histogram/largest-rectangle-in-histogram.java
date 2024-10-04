class State {
    int index;
    int height;
    public State(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<State> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentIndex = i, currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().height > currentHeight) {
                State lastRec = stack.pop();
                int lastArea = (i - lastRec.index) * lastRec.height;
                result = Math.max(result, lastArea);
                currentIndex = lastRec.index;
            }

            stack.push(new State(currentIndex, currentHeight));
        }

        while (!stack.isEmpty()) {
            State lastRec = stack.pop();
            int lastArea = (heights.length - lastRec.index) * lastRec.height;
            result = Math.max(result, lastArea);
        }
        return result;
    }
}