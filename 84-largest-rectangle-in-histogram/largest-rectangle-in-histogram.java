class Pair {
    int height;
    int index;
    public Pair(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int currentIndex = i, currentHeight = heights[i];
        
            while (!stack.isEmpty() && stack.peek().height >= currentHeight) {
                Pair lastRec = stack.pop();
                result = Math.max(result, lastRec.height * (i - lastRec.index));
                currentIndex = lastRec.index;        
            }
        
            stack.push(new Pair(currentHeight, currentIndex));
        }
        while (!stack.isEmpty()) {
            Pair lastRec = stack.pop();
            result = Math.max(result, (heights.length - lastRec.index) * lastRec.height);
        }
        return result;
    }
}