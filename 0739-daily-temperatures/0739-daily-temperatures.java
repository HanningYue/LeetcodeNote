/*
For current index i, what is the distance to nearest index j where temp[j] > temp[i]
Solve with a stack, add all the temperature to stack
    iterate the temperature, If current temp is greater than the LAST IN temp
    Last temp index = current temp index - last temp index
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int lastTempIndex = stack.pop();
                result[lastTempIndex] = i - lastTempIndex;
            }
            stack.push(i);
        }
        return result;
    }
}