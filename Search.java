import java.util.*;

public class Search<V> {
    protected Set<V> used;
    protected Map<V, V> edgeTo;
    protected final V from;

    public Search(V start) {
        this.from = start;
        used = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public Iterable<V> path(V v) {
        if (used.contains(v) == false)
            return null;
        LinkedList<V> p = new LinkedList<>();
        for (V i = v; i != from; i = edgeTo.get(i))
            p.push(i);
        p.push(from);
        return p;
    }
}
