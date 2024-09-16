class State {
    String dividend;
    double value;
    public State(String dividend, double value) {
        this.dividend = dividend;
        this.value = value;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<State>> graph = new HashMap<>();
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            
            graph.putIfAbsent(dividend, new ArrayList<>());
            graph.get(dividend).add(new State(divisor, values[i]));

            graph.putIfAbsent(divisor, new ArrayList<>());
            graph.get(divisor).add(new State(dividend, 1 / values[i]));
        }   

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfs(dividend, divisor, graph, 1, visited);
        }
        return result;
    }
    private double dfs(String dividend, String divisor, Map<String, List<State>> graph, double value, Set<String> visited) {
        if (!graph.containsKey(dividend) || visited.contains(dividend)) {
            return -1.0;
        }
        if (dividend.equals(divisor)) {
            return value;
        }
        visited.add(dividend);
        for (State neighbor : graph.get(dividend)) {
            double sub = dfs(neighbor.dividend, divisor, graph, value * neighbor.value, visited);
            if (sub != -1.0) {
                return sub;
            }
        }
        visited.remove(dividend);
        return -1.0;
    }
}