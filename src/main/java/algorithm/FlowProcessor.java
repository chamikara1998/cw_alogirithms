package algorithm;

/**
 * This class is use for process Flow of Diagrams
 */
public interface FlowProcessor {
    /**
     * This method is for calculate max flow
     * @param graph data structure
     * @param s starting node
     * @param t end node
     * @return maximum flow
     */
    int getMaxFlow(int graph[][], int s, int t);
}
