package day5;

import aw.logger.LoggerControler;
import org.testng.annotations.Test;

public class LoggerTest {
    final static LoggerControler log= LoggerControler.getLogger(LoggerTest.class);
    @Test
    public void testLog(){
        log.info("this is info log");
        log.warning("this is warn log");
        log.debug("this is error log");
        log.severe("this is error log");
    }
}
