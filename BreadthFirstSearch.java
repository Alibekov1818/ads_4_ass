import java.util.*;

public class BreadthFirstSearch <V> extends Search<V> {
    private void bfs(WeightedGraph<V> graph, V start) {
        used.add(start);
        Queue<V> q = new LinkedList<>();
        q.add(start);
        while (q.size() > 0) {
            V v = q.remove();
            for (V to : graph.adjacencyList(v)) {
                if (!used.contains(to)) {
                    edgeTo.put(to, v);
                    q.add(to);
                    used.add(to);
                }
            }
        }
    }
    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(start);
        bfs(graph, start);
    }
}