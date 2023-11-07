/**
Graph, run DFS
1. Create adjacency list, which needs to be SORTED! 
    -> Map<String, PriorityQueue<String>> //minHeap by default, natural ordering
    The priorityQueue here stores the LEXICOGRAPHICALLY smallest character
2. We want to print out the itinerary as a string List, use a Stack (LIFO) to help us construct travel path
3. We are running DFS on the graph, so the order should be reversed, We are given List<List<String>> tickets
    use LinkedList<String> to store travel path
4. If we reach a DEAD END, we need to BACKTRACK, 
    the condition to backtrack is when graph has no element -> graph.isEmpty() OR if (!graph.isEmpty) else
    When backtracking, add stack.pop to the Head of itinerary
5. When backtracking decision, declear next City as PEEK()!, when dead-end, add to head of itinerary use POP()!
Return itinerary
*/
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        for (List<String> ticket : tickets) {
            String departCity = ticket.get(0);
            String arriveCity = ticket.get(1);
            graph.putIfAbsent(departCity, new PriorityQueue<String>());
            graph.get(departCity).add(arriveCity);
        }
        
        while (!stack.isEmpty()) {
            String nextCity = stack.peek();
            
            if (!graph.getOrDefault(nextCity, new PriorityQueue<>()).isEmpty()) {
                stack.push(graph.get(nextCity).poll());
            } else {
                itinerary.add(stack.pop());
            }
        }
        Collections.reverse(itinerary);
        return itinerary;
    }
}