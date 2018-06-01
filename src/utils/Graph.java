package utils;

import java.util.*;

public class Graph {
    private int verticesCount;
    private Node vertices[];
    private Map<String, List<String>> edges = new HashMap<>();

    public Graph(){
        vertices = new Node[8];
        verticesCount = 0;
    }

    public void addEdge(String source, String destination) {
        List<String> sourceNeighbors = edges.get(source);
        if(sourceNeighbors == null){
            edges.put(source, sourceNeighbors = new ArrayList<>());
        }
        sourceNeighbors.add(destination);
    }

    public Iterable<String> getNeighbors(String vertex){
        List<String> neighbours = edges.get(vertex);
        if(neighbours == null){
            return Collections.emptyList();
        }else {
            return Collections.unmodifiableList(neighbours);
        }
    }
    public void addNode(Node newNode){
        if(verticesCount < 10){
            vertices[verticesCount] = newNode;
            verticesCount++;
        }else {
            System.out.println("Graph Full");
        }
    }

    public Node[] getVertices(){
        return vertices;
    }
}
