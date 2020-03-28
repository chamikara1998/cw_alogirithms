package algorithm;

import java.util.LinkedList;

public class MaximumFlowProcessor {

    private int vertices = 6;


    public MaximumFlowProcessor(int vertices) {
        this.vertices = vertices;
    }

    /* Returns true if there is a path from source 's' to sink
          't' in residual graph. Also fills parent[] to store the
          path */
    private boolean doBreathFirstSearch(int rGraph[][], int s, int t, int parent[]) {
        // Create a visited array and mark all vertices as not
        // visited
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; ++i)
            visited[i] = false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll(); // Get First Element Of Queue

            for (int v = 0; v < vertices; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph
    public int getMaxFlow(int graph[][], int s, int t) {
        int x, y;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[vertices][vertices];

        for (x = 0; x < vertices; x++)
            for (y = 0; y < vertices; y++)
                rGraph[x][y] = graph[x][y];

        // This array is filled by BFS and to store path
        int parent[] = new int[vertices];

        int max_flow = 0;  // There is no flow initially

        // Augment the flow while tere is path from source
        // to sink
        while (doBreathFirstSearch(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (y = t; y != s; y = parent[y]) {
                x = parent[y];
                path_flow = Math.min(path_flow, rGraph[x][y]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (y = t; y != s; y = parent[y]) {
                x = parent[y];
                rGraph[x][y] -= path_flow;
                rGraph[y][x] += path_flow;
            }

            // Add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;
    }
}
