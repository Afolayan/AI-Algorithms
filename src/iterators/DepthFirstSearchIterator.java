package iterators;

import utils.Graph;

import java.util.*;

public class DepthFirstSearchIterator implements Iterator<String> {
    private Set<String> visited = new HashSet<>();
    private Deque<Iterator<String>> stack = new LinkedList<>();
    private Graph graph;
    private String next;

    public DepthFirstSearchIterator(Graph graph, String startingVertex) {
        this.stack.push(graph.getNeighbors(startingVertex).iterator());
        this.graph = graph;
        this.next = startingVertex;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String next() {
        if(this.next == null){
            throw new NoSuchElementException("No such element");
        }
        try {
            this.visited.add(this.next);
            return this.next;
        }finally {
            this.advance();
        }
    }

    private void advance() {
        Iterator<String> neighbors = this.stack.peek();
        do{
            while (!neighbors.hasNext()){
                this.stack.pop();
                if(this.stack.isEmpty()){
                    this.next = null;
                    return;
                }
                neighbors = this.stack.peek();
            }this.next = neighbors.next();
        } while (this.visited.contains(this.next));
        this.stack.push(this.graph.getNeighbors(this.next).iterator());

    }
}
