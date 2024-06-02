class Node {
    String key;
    double value;
    public Node(String key, double value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, 
    List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            graph.putIfAbsent(dividend, new ArrayList<>());
            graph.get(dividend).add(new Node(divisor, values[i]));

            graph.putIfAbsent(divisor, new ArrayList<>());
            graph.get(divisor).add(new Node(dividend, 1 / values[i]));
        }
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfs(graph, dividend, divisor, 1, visited);
        }
        return result;
    }
    private double dfs(Map<String, List<Node>> graph, String dividend, String divisor, 
                       double value, Set<String> visited) {
        if (visited.contains(dividend) || !graph.containsKey(dividend)) {
            return -1.0;
        }
        if (dividend.equals(divisor)) {
            return value;
        }
        visited.add(dividend);
        for (Node neighbor : graph.get(dividend)) {
            double sub = dfs(graph, neighbor.key, divisor, value * neighbor.value, visited);
            if (sub != -1.0) {
                return sub;
            }
        }
        visited.remove(dividend);
        return -1.0;
    }
}