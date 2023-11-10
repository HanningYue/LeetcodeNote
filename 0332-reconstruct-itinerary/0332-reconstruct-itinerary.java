/**
Graph, run DFS, We can use Collections.reverse() or LinkedList addFirst
1. Create adjacency list, which needs to be SORTED! 
    双层数据结构 -> Map<String, PriorityQueue<String>> //minHeap by default, natural ordering
    The priorityQueue here stores the LEXICOGRAPHICALLY smallest character
2. We want to print out the itinerary as a string List, use a Stack (LIFO) to help us construct travel path, the LAST IN CITY IS THE NEXT DEPART.
3. If we have city in the minHeap, push to stack
4. If we reach a DEAD END, we need to BACKTRACK, 
    The condition to backtrack is when graph has no element -> graph.isEmpty() OR if (!graph.isEmpty) else
    When backtracking decision, declear next City as PEEK()!, when dead-end, add to itinerary use POP()!
5. We are running DFS, so the order should be reversed
Return itinerary
*/
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            String departCity = ticket.get(0);
            String arriveCity = ticket.get(1);
            graph.putIfAbsent(departCity, new PriorityQueue<String>());
            graph.get(departCity).add(arriveCity);
        }
        
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String nextCity = stack.peek();
            if (!graph.getOrDefault(nextCity, new PriorityQueue<>()).isEmpty()) {
                stack.push(graph.get(nextCity).poll());
            } else {
                result.add(stack.pop());
            }
        }
        Collections.reverse(result);
        return result;
    }
}