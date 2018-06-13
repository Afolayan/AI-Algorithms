import iterators.BreadthFirstIterator;
import iterators.DepthFirstSearchIterator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.Graph;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class UninformedSearchTest {

    public static Graph graph1;

    @BeforeClass
    public static void makeGraphs() {
        Graph g = graph1 = new Graph();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        g.addEdge("D", "I");
        g.addEdge("D", "J");
        g.addEdge("I", "K");
        g.addEdge("I", "L");
        g.addEdge("C", "F");
        g.addEdge("C", "G");
    }

    private void expectIteration(String answer, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        System.out.println(sb.toString());
        assertEquals(answer, sb.substring(1));
    }

    private void expectIterationToGoal(String answer, String goal, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String nextItem = it.next();
            sb.append(' ').append(nextItem);
            if(nextItem.equals(goal)) break;
        }
        System.out.println(sb.toString());
        assertEquals(answer, sb.substring(1));
    }

    @Test
    public void DepthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new DepthFirstSearchIterator(graph1, "Z"));
    }

    @Test
    public void DepthFirstIterationFromA() {
        expectIteration("A B D I K L J E C F G", new DepthFirstSearchIterator(graph1, "A"));
    }

    @Test
    public void DepthFirstIterationFromB() {
        expectIteration("B D I K L J E", new DepthFirstSearchIterator(graph1, "B"));
    }

    @Test
    public void DepthFirstIterationToGoalF() {
        expectIterationToGoal("A B D I K L J E C F", "F", new DepthFirstSearchIterator(graph1, "A"));
    }

    @Test
    public void BreadthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new BreadthFirstIterator(graph1, "Z"));
    }

    @Test
    public void BreadthFirstIterationFromA() {
        expectIteration("A B C D E F G I J K L", new BreadthFirstIterator(graph1, "A"));
    }

    @Test
    public void BreadthFirstIterationFromB() {
        expectIteration("B D E I J K L", new BreadthFirstIterator(graph1, "B"));
    }
}