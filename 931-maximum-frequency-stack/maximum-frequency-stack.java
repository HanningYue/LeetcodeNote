class FreqStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> mapStack;
    int maxFreq;
    public FreqStack() {
        mapStack = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        mapStack.putIfAbsent(freq, new Stack<Integer>());
        mapStack.get(freq).add(val);
    }
    
    public int pop() {
        int result = mapStack.get(maxFreq).pop();
        map.put(result, map.get(result) - 1);

        if (mapStack.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */