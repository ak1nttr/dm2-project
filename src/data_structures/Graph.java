/*
*       This project is created by Akın Tatar
*       Project structure is containing several graph necessity constraints
*       and other required methods to be used in other algorithms
*       bfs and dfs is implemented
*       print function is also provided for some console testing
*
*
*
*
*
* */

package data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
        vertices = new ArrayList<>();

    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex origin, Vertex destination, Integer weight) {
        if (!isWeighted) weight = null;
        origin.addEdge(destination, weight);
        if (!isDirected) destination.addEdge(origin, weight);
    }

    public void removeEdge(Vertex origin, Vertex destination) {
        origin.removeEdge(destination);
        if (!isDirected) destination.removeEdge(origin);
    }

    public void removeVertex(Vertex vertex) {
        vertices.removeIf(v -> v.equals(vertex));
    }

    public void print() {
        for (Vertex v : vertices) {
            v.print(isWeighted());
        }
    }

    public Vertex getVertexByData(String data) {
        for (Vertex v : vertices) {
            if (v.getData().equals(data)) {
                return v;
            }
        }
        System.out.println("not found!");
        return null;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }
    public void dfs(Vertex start, Set<Vertex> visited){
        //recursive
        //look for all the neighbours
        //mark the visited vertices
        System.out.print(start.getData());
        visited.add(start);
        for (Edge e : start.getEdges()){
            if (!visited.contains(e.getDestination())){
                System.out.print(" ");
                dfs(e.getDestination(),visited);
            }

        }
    }
    public void bfs(Vertex start){
        ArrayList<Vertex> visited = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            visited.add(current);
            System.out.print(current.getData()+" -> ");
            for (Edge e : current.getEdges()){
                if (!visited.contains(e.getDestination())){
                    queue.add(e.getDestination());
                }

            }
        }
    }
}
