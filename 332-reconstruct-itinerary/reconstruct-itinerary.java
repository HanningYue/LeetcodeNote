class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String depart = ticket.get(0);
            String arrive = ticket.get(1);
            graph.putIfAbsent(depart, new PriorityQueue<String>());
            graph.get(depart).add(arrive);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String lastCity = stack.peek();
            if (!graph.containsKey(lastCity) || graph.get(lastCity).isEmpty()) {
                result.add(0, stack.pop());
            } else {
                stack.push(graph.get(lastCity).poll());
            }
        }
        return result;
    }
}