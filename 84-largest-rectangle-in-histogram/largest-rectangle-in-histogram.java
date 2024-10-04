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
        int maxArea = 0;
        Stack<State> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int previousIndex = i, currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().height > currentHeight) {
                State previousRec = stack.pop();
                int localArea = (i - previousRec.index) * previousRec.height;
                maxArea = Math.max(maxArea, localArea);
                previousIndex = previousRec.index;
            }

            stack.push(new State(previousIndex, currentHeight));
        }

        while (!stack.isEmpty()) {
            State lastRec = stack.pop();
            int localArea = (heights.length - lastRec.index) * lastRec.height;
            maxArea = Math.max(maxArea, localArea);
        }
        return maxArea;
    }
}