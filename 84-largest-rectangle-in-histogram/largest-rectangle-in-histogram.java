class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int previousIndex = i, currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().height > currentHeight) {
                Pair lastRec = stack.pop();
                int area = (i - lastRec.index) * lastRec.height;
                maxArea = Math.max(maxArea, area);

                previousIndex = lastRec.index;
            }
            stack.push(new Pair(previousIndex, currentHeight));
        }

        while (!stack.isEmpty()) {
            Pair lastRec = stack.pop();
            int area = (heights.length - lastRec.index) * lastRec.height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
class Pair {
    int index, height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}