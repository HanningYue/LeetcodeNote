class Pair {
    int index, height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentIndex = i, currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().height > currentHeight) {
                Pair lastRec = stack.pop();
                int lastArea = (i - lastRec.index) * lastRec.height;
                maxArea = Math.max(maxArea, lastArea);
                
                currentIndex = lastRec.index;
            }
            stack.push(new Pair(currentIndex, currentHeight));
        }

        while (!stack.isEmpty()) {
            Pair lastRec = stack.pop();
            int lastArea = (heights.length - lastRec.index) * lastRec.height;
            maxArea = Math.max(maxArea, lastArea);
        }
        return maxArea;
    }
}