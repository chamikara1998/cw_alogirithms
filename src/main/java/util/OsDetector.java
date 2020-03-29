package util;

/**
 * This class for detect os
 */
public class OsDetector {

    public static Os detect(){
        String OS = System.getProperty("os.name").toLowerCase();
        if(isWindows(OS)){
            return Os.windows;
        }else {
            return Os.linux;
        }
    }

    private static boolean isWindows(String OS) {
        return OS.contains("win");
    }
}
