package components;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Component {


    @Override
    public void render() {
        renderMenu();
    }

    public void renderMenu() {
        System.out.println("Select option ");
        System.out.println("");
        System.out.println("1. Calculate max flow of network flow");
        System.out.println("2. Analyse algorithm");
        System.out.println("");
        System.out.print("option > ");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                Component calculator = new Calculator();
                calculator.render();
            } else if (choice == 2) {
                Component analyserGUI = new MaxFlowAnalyserGUI();
                analyserGUI.render();
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            renderMenu();
        }
    }
}
