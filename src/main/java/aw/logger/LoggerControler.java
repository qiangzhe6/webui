package aw.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;

/**
 * Created by lenovo on 2016/11/9.
 */
public class LoggerControler {
    private static Logger logger=null;
    public static LoggerControler getLogger(Class<?> T) {
        logger=Logger.getLogger(T);
        PropertyConfigurator.configure("D:\\mydoc\\webui\\config\\log4j.properties");
        return new LoggerControler();
    }
    //重写logger方法
    public static void debug(String msg) {
        logger.debug(msg);
    }
    public static void info(String msg){
        logger.info(msg);
    }
    public static void warning(String msg) {
        logger.warn(msg);
    }
    public static void severe(String msg) {
        logger.error(msg);
    }

}

