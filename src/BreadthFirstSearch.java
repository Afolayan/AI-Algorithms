import utils.Graph;
import utils.Node;
import utils.State;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {


    public void breadthFirstSearch(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return;
        root.setState(State.VISITED);
        queue.add(root);

        while (!queue.isEmpty()){
            Node nodeToRemove = queue.remove();
            System.out.print(nodeToRemove.getVertex()+"\n");
            for(Node node: nodeToRemove.getChild()){
                if(node.getState() == State.UNVISITED){
                    queue.add(node);
                    node.setState(State.VISITED);
                }
            }
        }
    }

    public static Graph createNewGraph(){
        Graph graph = new Graph();
        Node[] tempNode = new Node[8];

        tempNode[0] = new Node("A", 3);
        tempNode[1] = new Node("B", 3);
        tempNode[2] = new Node("C", 1);
        tempNode[3] = new Node("D", 1);
        tempNode[4] = new Node("E", 1);
        tempNode[5] = new Node("F", 1);

        tempNode[0].addChildNode(tempNode[1]);
        tempNode[0].addChildNode(tempNode[2]);
        tempNode[0].addChildNode(tempNode[3]);

        tempNode[1].addChildNode(tempNode[0]);
        tempNode[1].addChildNode(tempNode[4]);
        tempNode[1].addChildNode(tempNode[5]);

        tempNode[2].addChildNode(tempNode[0]);
        tempNode[3].addChildNode(tempNode[0]);
        tempNode[4].addChildNode(tempNode[1]);
        tempNode[5].addChildNode(tempNode[1]);

        for (int i = 0; i < 7; i++) {
            graph.addNode(tempNode[i]);
        }
        return graph;
    }
}
