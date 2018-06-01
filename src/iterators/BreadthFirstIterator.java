package iterators;

import utils.Graph;

import java.util.*;

public class BreadthFirstIterator implements Iterator<String> {

    private Set<String> visited = new HashSet<>();
    private Queue<String> queue = new LinkedList<>();
    private Graph graph;

    public BreadthFirstIterator(Graph graph, String startingVertex) {
        this.graph = graph;
        this.queue.add(startingVertex);
        this.visited.add(startingVertex);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public String next() {
        String next = queue.remove();
        for(String neighbour: this.graph.getNeighbors(next)){
            if(!this.visited.contains(neighbour)){
                this.queue.add(neighbour);
                this.visited.add(neighbour);
            }
        }
        return next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
