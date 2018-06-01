import iterators.DepthFirstSearchIterator
import org.junit.After
import org.junit.Before
import org.junit.Test
import utils.Graph

class MainTest extends GroovyTestCase {
    public static Graph graph
    @Before
    void setUp() {
        super.setUp()
        Graph g = graph1 = new Graph()
        g.addEdge("A", "B")
        g.addEdge("B", "C")
        g.addEdge("B", "D")
        g.addEdge("B", "A")
        g.addEdge("B", "E")
        g.addEdge("B", "F")
        g.addEdge("C", "A")
        g.addEdge("D", "C")
        g.addEdge("E", "B")
        g.addEdge("F", "B")
    }

    @After
    void tearDown() {
    }


    private void expectIteration(String answer, Iterator<String> it) {
        StringBuilder sb = new StringBuilder()
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        assertEquals(answer, sb.substring(1))
    }

    @Test
    void preOrderIterationOfIsolatedVertex() {
        expectIteration("Z", new DepthFirstSearchIterator(graph1, "Z"))
    }

}
