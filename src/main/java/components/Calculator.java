package components;

import algorithm.MaximumFlowProcessor;
import constants.ConsoleColors;
import sun.plugin2.util.SystemUtil;
import util.Os;
import util.OsDetector;

import java.util.Scanner;

public class Calculator implements Component {


    private void calculate(int vertices,int[][] dataStructure) {
        MaximumFlowProcessor maximumFlowProcessor = new MaximumFlowProcessor(vertices);

        System.out.println("The maximum possible flow is " +
                maximumFlowProcessor.getMaxFlow(dataStructure, 0, 5));
    }

    @Override
    public void render() {
        int vertices = getVertices();
        int[][] dataStructure = getDataStructure(vertices);
        calculate(vertices,dataStructure);
    }

    private int[][] getDataStructure(int vertices) {
        System.out.println();
        System.out.println("Enter Data Structure");
        System.out.println("Put spaces between two data points");
        Scanner scanner = new Scanner(System.in);
        int[][] dataStructure = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            String inputData = scanner.nextLine();
            String[] dataRowStrings = inputData.split(" ");
            for (int r = 0; r < vertices; r++) {
                dataStructure[i][r] = Integer.parseInt(dataRowStrings[r]);
            }
        }
        return dataStructure;
    }

    private int getVertices() {
        int vertices;
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of nodes -> ");
        if (OsDetector.detect() == Os.linux) {
            System.out.print(ConsoleColors.GREEN);
        }
        vertices = input.nextInt();
        if (OsDetector.detect() == Os.linux) {
            System.out.print(ConsoleColors.RESET);
        }
        return vertices;
    }
}
