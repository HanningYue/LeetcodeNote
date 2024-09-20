class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String lastCity = stack.peek();
            if (!graph.containsKey(lastCity) || graph.get(lastCity).isEmpty()) {
                result.add(stack.pop());
            } else {
                stack.push(graph.get(lastCity).poll());
            }
        }
        Collections.reverse(result);
        return result;
    }
}