import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, List<Vertex<V>>> mygraph = new HashMap<>();
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }
    public void addEdge(V from, V to, double w) {
        if (hasVertex(from) == false)
            addVertex(from);
        if (hasVertex(to) == false)
            addVertex(to);
        if (hasEdge(from, to) == true || from == to)
            return;
        mygraph.get(from).add(new Vertex<>(to, w));
        if (undirected == true)
            mygraph.get(to).add(new Vertex<>(from, w));
    }
    public void addVertex(V v) {
        mygraph.put(v, new LinkedList<>());
    }
    public boolean hasVertex(V v) {
        return mygraph.containsKey(v);
    }
    public boolean hasEdge(V v, V u) {
        if (hasVertex(v) == false)
            return false;
        return mygraph.get(v).contains(new Vertex<>(u));
    }
    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v))
            return null;
        List<V> adj = new LinkedList<>();
        for (Vertex<V> to : mygraph.get(v))
            adj.add(to.getAdj());
        return adj;
    }
    public double edgelen(V v, V u) {
        for (Vertex<V> to : mygraph.get(v))
            if (to.data == u)
                return to.weight;
        return 0D;
    }
}