package automation.utils;

import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class.getName());

    public static Logger getLogData(String className){
        String path = new File("").getAbsolutePath();
        DOMConfigurator.configure("log4j.xml");
        return Logger.getLogger(className);
    }

    public static void startTest(String testName){
        logger.info("Test called: " + testName + " has started");
    }

    public static void endTest(String testName){
        logger.info("Test called: " + testName + " has ended");
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void warn(String message){
        logger.warning(message);
    }

    public static void error(String message){
        logger.log (Level.SEVERE, message);
    }
    public static void debug(String message){
        logger.log(Level.ALL, message);
    }
}
