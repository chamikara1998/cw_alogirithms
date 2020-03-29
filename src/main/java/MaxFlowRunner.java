import components.Calculator;
import components.Component;
import components.Menu;
import components.Welcome;
import javafx.application.Application;

public class MaxFlowRunner {




    public static void main(String[] args){
        Component welcome = new Welcome();
        welcome.render();
        Component menu = new Menu();
        menu.render();
    }


}
