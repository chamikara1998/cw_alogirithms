import algorithm.MaximumFlowProcessor;

public class HelloWorld {

    private static final int vertices = 6;


    public static void main(String[] args){
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        MaximumFlowProcessor maximumFlowProcessor = new MaximumFlowProcessor(vertices);

        System.out.println("The maximum possible flow is " +
                maximumFlowProcessor.getMaxFlow(graph, 0, 5));
    }
}
