package components;

import algorithm.MaximumFlowProcessor;
import constants.ConsoleColors;
import sun.plugin2.util.SystemUtil;
import util.Os;
import util.OsDetector;

import java.util.Scanner;

public class Calculator implements Component{


    private void calculate(int vertices){
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

    @Override
    public void render() {
        int vertices = getVertices();
        int[][] dataStructure = getDataStructure(vertices);
        calculate(vertices);
    }

    private int[][] getDataStructure(int vertices) {
        System.out.println();
        System.out.println("Enter Data Structure");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i<vertices;i++){
            scanner.nextInt();
            System.out.print(" | ");
        }
        return null;
    }

    private int getVertices(){
        int vertices;
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of nodes -> ");
        if(OsDetector.detect() == Os.linux){
            System.out.print(ConsoleColors.GREEN);
        }
        vertices = input.nextInt();
        if(OsDetector.detect() == Os.linux){
            System.out.print(ConsoleColors.RESET);
        }
        return vertices;
    }
}
