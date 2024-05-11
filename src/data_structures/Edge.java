package data_structures;

public class Edge {

    private Integer weight;
    private Vertex origin;
    private Vertex destination;

    public Edge(Integer weight, Vertex origin, Vertex destination) {
        this.weight = weight;
        this.origin = origin;
        this.destination = destination;
    }


    public Integer getWeight() {
        return weight;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public Vertex getDestination() {
        return destination;
    }
}