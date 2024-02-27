class Node {
    public String key;
    public double val;
    public Node(String key, double val) {
        this.key = key;
        this.val = val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> currentEquation = equations.get(i);
            String dividend = currentEquation.get(0);
            String divisor = currentEquation.get(1);
            graph.putIfAbsent(dividend, new ArrayList<>());
            graph.get(dividend).add(new Node(divisor, values[i]));

            graph.putIfAbsent(divisor, new ArrayList<>());
            graph.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            List<String> currentQuery = queries.get(i);
            String dividend = currentQuery.get(0);
            String divisor = currentQuery.get(1);
            result[i] = dfs(graph, dividend, divisor, 1.0, new HashSet<>());
        }
        return result;
    }
    public double dfs(Map<String, List<Node>> graph, String dividend, String divisor, double value, Set<String> visited) {
        if (!graph.containsKey(dividend)) {
            return -1.0;
        }
        if (visited.contains(dividend)) {
            return -1.0;
        }
        if (dividend.equals(divisor)) {
            return value;
        }

        visited.add(dividend);
        for (Node neighbor : graph.get(dividend)) {
            double sub = dfs(graph, neighbor.key, divisor, value * neighbor.val, visited);
            if (sub != -1.0) {
                return sub;
            }
        }
        visited.remove(dividend);
        return -1.0;
    }
}