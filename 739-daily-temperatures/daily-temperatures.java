/**
1. Stack, saving the Index of each daily temperatures, from left to right
2. Iterate the array, compare current temperatures with the previous(stack.peek())
3. If previous temperatures are lower, fill result int[] with Index Difference
*/
//For better Time-Complexity, use a Deque and ArrayDeque instead of Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int lastIndex = stack.pop();
                answer[lastIndex] = i - lastIndex;
            }
            stack.push(i);
        }     
        return answer;
    }
}