import iterators.BreadthFirstIterator;
import iterators.DepthFirstSearchIterator;
import org.junit.Test;
import utils.Graph;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class Main {
    private static Graph graph1;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Graph g = graph1 = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "A");
        g.addEdge("D", "C");
        g.addEdge("E", "B");
        g.addEdge("F", "B");


        DepthFirstIterationFromA();
        DepthFirstIterationFromB();
        DepthFirstIterationToGoalF();
        BreadthFirstIterationOfIsolatedVertex();
        BreadthFirstIterationFromA();
        BreadthFirstIterationFromB();
        DepthFirstIterationOfIsolatedVertex();
    }

    public static void DepthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new DepthFirstSearchIterator(graph1, "Z"));
    }

    public static void DepthFirstIterationFromA() {
        expectIteration("A B D I K L J E C F G", new DepthFirstSearchIterator(graph1, "A"));
    }

    public static void DepthFirstIterationFromB() {
        expectIteration("B D I K L J E", new DepthFirstSearchIterator(graph1, "B"));
    }

    public static void DepthFirstIterationToGoalF() {
        expectIterationToGoal("A B D I K L J E C F", "F", new DepthFirstSearchIterator(graph1, "A"));
    }

    public static void BreadthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new BreadthFirstIterator(graph1, "Z"));
    }

    public static void BreadthFirstIterationFromA() {
        expectIteration("A B C D E F G I J K L", new BreadthFirstIterator(graph1, "A"));
    }


    public static void BreadthFirstIterationFromB() {
        expectIteration("B D E I J K L", new BreadthFirstIterator(graph1, "B"));
    }

    private static void expectIteration(String answer, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        System.out.println(sb.toString());
        //assertEquals(answer, sb.substring(1));
    }

    private static void expectIterationToGoal(String answer, String goal, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String nextItem = it.next();
            sb.append(' ').append(nextItem);
            if(nextItem.equals(goal)) break;
        }
        System.out.println(sb.toString());
        //assertEquals(answer, sb.substring(1));
    }
}
