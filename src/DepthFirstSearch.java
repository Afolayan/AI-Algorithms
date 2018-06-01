import utils.Node;
import utils.State;

public class DepthFirstSearch {

    public void depthFirstSearch(Node rootNode){
        if(rootNode == null) return;
        System.out.print(rootNode.getVertex()+"\t");
        rootNode.setState(State.VISITED);

        for(Node node: rootNode.getChild()){
            if(node.getState() == State.UNVISITED){
                depthFirstSearch(node);
            }
        }
    }
}
