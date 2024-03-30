class Pair {
    int index, height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public int getIdx() {
        return index;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentIdx = i;
            int currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().getHeight() > currentHeight) {
                Pair lastRectangle = stack.pop();
                int lastIdx = lastRectangle.getIdx();
                int lastHeight = lastRectangle.getHeight();

                result = Math.max(result, (i - lastIdx) * lastHeight);
                currentIdx = lastIdx;
            }
            stack.push(new Pair(currentIdx, currentHeight));
        }

        while (!stack.isEmpty()) {
            Pair lastRectangle = stack.pop();
            int lastIdx = lastRectangle.getIdx();
            int lastHeight = lastRectangle.getHeight();
            
            result = Math.max(result, (heights.length - lastIdx) * lastHeight);
        }
        return result;
    }
}