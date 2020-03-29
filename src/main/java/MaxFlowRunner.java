import components.Calculator;
import components.Component;
import components.Welcome;
import javafx.application.Application;

public class MaxFlowRunner {




    public static void main(String[] args){
        Component welcome = new Welcome();
        welcome.render();
        Component calculator = new Calculator();
        calculator.render();
//        launchAnalyserGUI();
    }

    private static void launchAnalyserGUI(){
        Application.launch(MaxFlowAnalyserGUI.class);
    }
}
