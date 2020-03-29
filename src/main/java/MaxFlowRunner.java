
import components.Component;
import components.Menu;
import components.Welcome;

/**
 * This is the main class which used for run application
 */
public class MaxFlowRunner {

    /**
     * This is main method of application
     * @param args
     */
    public static void main(String[] args){
        Component welcome = new Welcome();
        welcome.render();
        Component menu = new Menu();
        menu.render();
    }


}
