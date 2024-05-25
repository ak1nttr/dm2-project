/*
*       This project is created by Akın Tatar , Ozan Ergüleç , Seher Oğuz
*       Project structure is containing several graph necessity constraints
*       and other required methods to be used in other algorithms
*       bfs and dfs is implemented
*       print function is also provided for some console testing
*
*       calculateEccentricity,
*       calculateDiameter,
*       calculateRadius
*       methods are implemented
*
*
*
*
*
* */

package data_structures;

import java.util.*;

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

    // DFS IMPLEMENTATION
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
    // BFS IMPLEMENTATION
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

    // ALL THREE DISTRIBUTED ALGORITHMS ARE IMPLEMENTED
    //
    // 1 - CALCULATE ECCENTRICITY FOR A GIVEN NODE AS A PARAMETER
    public int calculateEccentricity(Vertex node) {
        Map<Vertex, Integer> distances = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(node);
        distances.put(node, 0);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Edge e : current.getEdges()) {
                if (!distances.containsKey(e.getDestination())) {
                    queue.offer(e.getDestination());
                    distances.put(e.getDestination(), distances.get(current) + 1);
                }
            }
        }

        return Collections.max(distances.values());
    }

    // 2 - CALCULATE DIAMETER FOR A GIVEN GRAPH AS A PARAMETER
    public int calculateDiameter() {
        int maxEccentricity = 0;
        for (Vertex v : vertices) {
            int ecc = calculateEccentricity(v);
            maxEccentricity = Math.max(maxEccentricity, ecc);
        }
        return maxEccentricity;
    }

    // 3 - CALCULATE RADIUS FOR A GIVEN GRAPH AS A PARAMETER
    public int calculateRadius() {
        int minEccentricity = Integer.MAX_VALUE;
        for (Vertex v : vertices) {
            int ecc = calculateEccentricity(v);
            minEccentricity = Math.min(minEccentricity, ecc);
        }
        return minEccentricity;
    }


}
