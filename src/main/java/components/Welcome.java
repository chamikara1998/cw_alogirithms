package components;


import constants.ConsoleColors;
import util.Os;
import util.OsDetector;

/**
 * This method is for render welcome component
 */
public class Welcome implements Component {


    /**
     * This method is for render this component
     */
    @Override
    public void render() {
        if(OsDetector.detect() == Os.linux){
            System.out.print(ConsoleColors.RED);
        }
        System.out.println("  __  __          __   __      ______ _      ______          __\n" +
                " |  \\/  |   /\\    \\ \\ / /     |  ____| |    / __ \\ \\        / /\n" +
                " | \\  / |  /  \\    \\ V /      | |__  | |   | |  | \\ \\  /\\  / / \n" +
                " | |\\/| | / /\\ \\    > <       |  __| | |   | |  | |\\ \\/  \\/ /  \n" +
                " | |  | |/ ____ \\  / . \\      | |    | |___| |__| | \\  /\\  /   \n" +
                " |_|  |_/_/    \\_\\/_/ \\_\\     |_|    |______\\____/   \\/  \\/    ");
        if(OsDetector.detect() == Os.linux){
            System.out.print(ConsoleColors.YELLOW_BRIGHT);
        }
        System.out.println(" ===========================================================");
        System.out.println("               Welcome to Max Flow Calculator");
        System.out.println(" ===========================================================");
        if(OsDetector.detect() == Os.linux){
            System.out.print(ConsoleColors.RESET);
        }
        System.out.println("");
    }


}
