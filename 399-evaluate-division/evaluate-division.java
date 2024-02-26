class Node {
    String num;
    double val;
    public Node(String num, double val) {
        this.num = num;
        this.val = val;
    }
}
class Solution {
    Map<String, List<Node>> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            if (!map.containsKey(dividend)) {
                map.put(dividend, new ArrayList<>());
            }
            map.get(dividend).add(new Node(divisor, values[i]));

            if (!map.containsKey(divisor)) {
                map.put(divisor, new ArrayList<>());
            }
            map.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            String num1 = queries.get(i).get(0);
            String num2 = queries.get(i).get(1);
            result[i] = dfs(num1, num2, 1, new HashSet<>());
        }
        return result;
    }
    private double dfs(String start, String end, double value, HashSet<String> visited) {
        if (!map.containsKey(start)) {
            return -1;
        }
        if (visited.contains(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return value;
        }
        visited.add(start);
        for (Node next : map.get(start)) {
            double sub = dfs(next.num, end, value * next.val, visited);
            if (sub != -1.0) {
                return sub;
            }
        }
        visited.remove(start);
        return -1;
    }
}