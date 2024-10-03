
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EvaluateDivision {

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);

            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                res[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                double[] total = { -1.0 };
                dfs(numerator, denominator, graph, visited, total, 1.0);
                res[i] = total[0];
            }
        }
        return res;
    }

    static void dfs(String source, String destination, Map<String, Map<String, Double>> graph, Set<String> visited,
            double[] total, double runner) {
        if (visited.contains(source)) {
            return;
        }
        visited.add(source);

        if (source.equals(destination)) {
            total[0] = runner;
            return;
        }

        for (Map.Entry<String, Double> map : graph.get(source).entrySet()) {
            String node = map.getKey();
            double value = map.getValue();
            dfs(node, destination, graph, visited, total, runner * value);
        }
    }

    static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());

            graph.get(numerator).put(denominator, values[i]);
            graph.get(denominator).put(numerator, 1.0 / values[i]);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(calcEquation(
                Arrays.stream(new String[][] { { "a", "b" }, { "b", "c" } }).map(Arrays::asList)
                        .collect(Collectors.toList()),
                new double[] { 2.0, 3.0 },
                Arrays.stream(new String[][] { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } })
                        .map(Arrays::asList).collect(Collectors.toList())));
    }
}
