/*
1. Each node has a list of neighbors, we need to perform dfs1 on the neighbors of each node
2. Add copys of neighbor to the list of current copy (current level)
3. Using a hashmap checking if the current node is already visited
*/
class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}