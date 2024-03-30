class Pair {
    int key, value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int currentIdx = i;
            int currentHeight = heights[i];

            while (!stack.isEmpty() && stack.peek().getValue() > currentHeight) {
                Pair lastRectangle = stack.pop();
                int lastIdx = lastRectangle.getKey();
                int lastHeight = lastRectangle.getValue();

                result = Math.max(result, (i - lastIdx) * lastHeight);
                currentIdx = lastIdx;
            }
            stack.push(new Pair(currentIdx, currentHeight));
        }

        while (!stack.isEmpty()) {
            Pair lastRectangle = stack.pop();
            int lastIdx = lastRectangle.getKey();
            int lastHeight = lastRectangle.getValue();
            result = Math.max(result, (heights.length - lastIdx) * lastHeight);
        }
        return result;
    }
}