package components;

import algorithm.MaximumFlowProcessor;
import constants.ConsoleColors;
import javafx.application.Application;
import sun.plugin2.util.SystemUtil;
import util.Os;
import util.OsDetector;

import java.util.Scanner;

public class Calculator implements Component {

    int[][] dataStructure;

    private void calculate() {
        MaximumFlowProcessor maximumFlowProcessor = new MaximumFlowProcessor(dataStructure[0].length);

        System.out.println("The maximum possible flow is " +
                maximumFlowProcessor.getMaxFlow(dataStructure, 0, 5));
    }

    @Override
    public void render() {
        int vertices = getVertices();
        dataStructure = getDataStructure(vertices);
        calculate();
        renderChoice();
    }

    private void renderChoice() {
        System.out.println("Do you want to Edit Data Structure ? (Yes/No)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.toLowerCase().equals("yes")) {
            renderEditWindow();
        } else if (choice.toLowerCase().equals("no")) {
            System.exit(1);
        }
        renderChoice();
    }

    private void renderEditWindow() {
        Scanner scanner = new Scanner(System.in);
        if (OsDetector.detect() == Os.linux) {
            System.out.println("Enter " + ConsoleColors.YELLOW + " from node " + ConsoleColors.RESET + " which do you want to edit.");
        } else {
            System.out.println("Enter from node which do you want to edit.");
        }
        int fromNode = scanner.nextInt();
        if (OsDetector.detect() == Os.linux) {
            System.out.println("Enter " + ConsoleColors.YELLOW + " to node " + ConsoleColors.RESET + " which do you want to edit.");
        } else {
            System.out.println("Enter to node which do you want to edit.");
        }
        int toNode = scanner.nextInt();
        if (OsDetector.detect() == Os.linux) {
            System.out.println("Enter to edge value.");
        } else {
            System.out.println("Enter to edge value.");
        }
        int edgeValue = scanner.nextInt();
        changeDataStructure(fromNode, toNode, edgeValue);
        calculate();
    }

    private void changeDataStructure(int fromNode, int toNode, int edge) {
        dataStructure[fromNode][toNode] = edge;
    }

    private int[][] getDataStructure(int vertices) {
        System.out.println();
        System.out.println("Enter Data Structure");
        System.out.println("Put commas between two data points");
        Scanner scanner = new Scanner(System.in);
        int[][] dataStructure = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            try {
                String inputData = scanner.nextLine();
                String[] dataRowStrings = inputData.split(",");
                if(dataRowStrings.length > vertices) throw new ArrayIndexOutOfBoundsException("Invalid Input");
                for (int r = 0; r < vertices; r++) {
                    dataStructure[i][r] = Integer.parseInt(dataRowStrings[r].trim());
                }
            }catch (NumberFormatException e){
                if(OsDetector.detect() == Os.linux){
                    System.out.println(ConsoleColors.RED);
                }
                System.out.println("Invalid Input : " + e.getMessage() + ". Please enter valid data structure row.");
                i =- 1;
                if(OsDetector.detect() == Os.linux){
                    System.out.println(ConsoleColors.RESET);
                }
            } catch (ArrayIndexOutOfBoundsException e){
                if(OsDetector.detect() == Os.linux){
                    System.out.println(ConsoleColors.RED);
                }
                System.out.println("Invalid Input : expected " + vertices + " data columns");
                i =- 1;
                if(OsDetector.detect() == Os.linux){
                    System.out.println(ConsoleColors.RESET);
                }
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
