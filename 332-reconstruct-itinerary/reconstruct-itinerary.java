class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
                stack.push(graph.get(stack.peek()).poll());
            }
            result.add(0, stack.pop()); // add to result in reverse order
        }
        return result;
    }
}
