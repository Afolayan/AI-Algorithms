package utils;

public class Node {
    public Node[] child;
    public int childCount;
    private String vertex;
    private State state;

    public Node(String vertex){
        this.vertex = vertex;
    }

    public Node(String vertex, int children){
        this.vertex = vertex;
        childCount = 0;
        child = new Node[children];
    }

    public void addChildNode(Node adjacentNode){
        adjacentNode.state = State.UNVISITED;
        if(childCount < 30){
            this.child[childCount] = adjacentNode;
            childCount++;
        }
    }
    public void setChild(Node[] child) {
        this.child = child;
    }

    public Node[] getChild(){
        return child;
    }

    public String getVertex(){
        return vertex;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
