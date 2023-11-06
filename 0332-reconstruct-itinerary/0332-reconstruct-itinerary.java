/**
Graph, with DFS
1. Create adjacency list, which needs to be SORTED! -> Map<String, PriorityQueue<String>>
Return the sorted lexical ordering
*/
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (List<String> ticket : tickets) {
            String depart = ticket.get(0);
            String arrive = ticket.get(1);
            graph.putIfAbsent(depart, new PriorityQueue<>());
            graph.get(depart).add(arrive);
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String nextArrival = stack.peek();

            if (!graph.getOrDefault(nextArrival, new PriorityQueue<>()).isEmpty()) {
                stack.push(graph.get(nextArrival).poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }
}