public class Vertex<V> {
    V data;
    double weight;
    Vertex(V data) {
        this.data = data;
    }
    Vertex(V data, double weight) {
        this.data = data;
        this.weight = weight;
    }
    public V getAdj() {
        return this.data;
    }
}
