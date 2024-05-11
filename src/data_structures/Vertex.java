package data_structures;

import java.util.ArrayList;

public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String data){
        this.data = data;
        edges = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void addEdge(Vertex destination , Integer weight){
        Edge newEdge = new Edge(weight,this,destination);
        edges.add(newEdge);
    }

    public void removeEdge(Vertex destination){
        edges.removeIf(edge -> edge.getDestination().equals(destination));
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void print(boolean isWeighted){
        String msg ="";
        if (edges.isEmpty()){
            System.out.println(this.data + " -> ");
            return;
        }
        msg +=data+" -> ";
        for (int i =0;i<edges.size();i++){

            msg +=edges.get(i).getDestination().data;

            if (isWeighted){
                msg +=" ("+ edges.get(i).getWeight()+") ";
            }
            if (i != edges.size()-1){
                msg +=" , ";
            }
        }
        System.out.println(msg);
    }

}
