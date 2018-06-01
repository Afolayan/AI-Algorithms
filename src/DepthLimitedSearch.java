import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DepthLimitedSearch {
    private Stack<Integer> stack;
    private int numberOfNodes;
    private static final int MAX_DEPTH = 3;

    public DepthLimitedSearch(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.stack = new Stack<Integer>();
    }

    public void depthLimitedSearch(int adjacencyMatrix[][], int source) {
        int visited[] = new int[numberOfNodes + 1];
        int element, destination;
        int depth = 0;

        System.out.println(source + " at depth " + depth);
        stack.push(source);
        visited[source] = 1;
        depth = 0;

        while (!stack.isEmpty()) {
            element = stack.peek();
            destination = element;
            while (destination <= numberOfNodes) {
                if (depth < MAX_DEPTH) {
                    if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 0) {
                        stack.push(destination);
                        visited[destination] = 1;
                        depth++;
                        System.out.println(destination + " at depth " + depth);
                        element = destination;
                        destination = 1;
                    }
                } else {
                    return;
                }
                destination++;
            }
            stack.pop();
            depth--;
        }
    }

    public static void main(String... arg) {
        int numberOfNodes, source;
        Scanner scanner = null;
        try {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            numberOfNodes = 6;

            int[][] adjacencyMatrix = {
                    {0, 1, 0, 1, 0, 0},
                    {1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1},
                    {0, 0, 1, 0, 1, 0},
            };
            /*int adjacencyMatrix[][] = new int[numberOfNodes + 1][numberOfNodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= numberOfNodes; i++)
                for (int j = 1; j <= numberOfNodes; j++)
                    adjacencyMatrix[i][j] = scanner.nextInt();

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();*/
            source = 1;
            System.out.println("The Depth limited Search Traversal of Max Depth 3 is");
            DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(numberOfNodes);
            depthLimitedSearch.depthLimitedSearch(adjacencyMatrix, source);

        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}