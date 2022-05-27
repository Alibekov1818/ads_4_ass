import java.util.HashMap;

import java.util.HashSet;

import java.util.Map;

import java.util.Set;

public class DijkstraSearch<V> extends Search<V> {
    private WeightedGraph<V> g;
    private Set<V> q;
    private Map<V, Double> d;
    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        d = new HashMap<>();
        q = new HashSet<>();
        this.g = graph;
        dijkstra();
    }
    private V get() {
        V ans = null;
        for (V cur : q)
            if (ans == null || distTo(cur) < distTo(ans))
                ans = cur;
        return ans;
    }
    private double dist(V x, V y) {
        return g.edgelen(y, x);
    }
    public void dijkstra() {
        d.put(from, 0D);
        q.add(from);
        while (q.size() > 0) {
            V v = get();
            used.add(v);
            q.remove(v);
            for (V to : g.adjacencyList(v)) {
                double len = distTo(v) + dist(to, v);
                if (distTo(to) > len) {
                    d.put(to, len);
                    edgeTo.put(to, v);
                    q.add(to);
                }
            }
        }
    }
    private double distTo(V v) {
        Double len = d.get(v);
        return len == null ? 1e9 + 123 : len;
    }
}