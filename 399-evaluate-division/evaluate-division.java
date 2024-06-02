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
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            graph.putIfAbsent(dividend, new ArrayList<>());
            graph.get(dividend).add(new Node(divisor, values[i]));

            graph.putIfAbsent(divisor, new ArrayList<>());
            graph.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfs(dividend, divisor, graph, 1, visited);
        }
        return result;
    }

    private double dfs(String dividend, String divisor, Map<String, List<Node>> graph, 
    double value, Set<String> visited) {
        if (visited.contains(dividend) || !graph.containsKey(dividend)) {
            return -1.0;
        }
        if (dividend.equals(divisor)) {
            return value;
        }

        visited.add(dividend);
        for (Node neighbor : graph.get(dividend)) {
            double subProblem = dfs(neighbor.key, divisor, graph, neighbor.value * value, visited);
            if (subProblem != -1.0) {
                return subProblem;
            }
        }
        visited.remove(dividend);
        return -1.0;
    }
}