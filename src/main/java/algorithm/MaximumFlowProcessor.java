package algorithm;

import constants.ConsoleColors;
import util.Os;
import util.OsDetector;

import java.util.LinkedList;

public class MaximumFlowProcessor implements FlowProcessor {

    private int vertices = 6;

    private boolean doBreathFirstSearch(int[][] graph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (queue.size() != 0) {
            int x = queue.poll(); // Get First Element Of Queue

            for (int y = 0; y < vertices; y++) {
                if (!visited[y] && graph[x][y] > 0) {
                    queue.add(y);
                    parent[y] = x;
                    visited[y] = true;
                }
            }
        }
        return (visited[t]);
    }

    public int getMaxFlow(int[][] graph, int s, int t) {
        vertices = graph[0].length;
        int x, y;
        int[] parent = new int[vertices];
        int rGraph[][] = new int[vertices][vertices];
        int finalGraph[][] = new int[vertices][vertices];

        for (x = 0; x < vertices; x++)
            for (y = 0; y < vertices; y++)
                rGraph[x][y] = graph[x][y];
        int max_flow = 0;
        while (doBreathFirstSearch(rGraph, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (y = t; y != s; y = parent[y]) {
                x = parent[y];
                path_flow = Math.min(path_flow, rGraph[x][y]);
            }

            for (y = t; y != s; y = parent[y]) {
                x = parent[y];
                rGraph[x][y] -= path_flow;
                rGraph[y][x] += path_flow;
                finalGraph[x][y] += path_flow;
            }

            max_flow += path_flow;
        }

        System.out.println("");
        System.out.println("Maximum flow path");
        System.out.println("==================");
        if (OsDetector.detect() == Os.linux) {
            System.out.println(ConsoleColors.BLUE_BRIGHT);
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                int value = finalGraph[i][j];
                if (value != 0) {
                    System.out.println(i + " -> " + j + " = " + value);
                }
            }
        }
        if (OsDetector.detect() == Os.linux) {
            System.out.println(ConsoleColors.RESET);
        }
        return max_flow;
    }
}
