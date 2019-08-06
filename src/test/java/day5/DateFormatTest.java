package day5;

import org.testng.annotations.Test;
import aw.tools.DateFormat;

public class DateFormatTest {
    @Test
    public void DateTime(){
        System.out.println(DateFormat.format(DateFormat.ZC_DATE_FORMAT));
    }
    @Test
    public void CuoTime(){
        System.out.println(DateFormat.time());
    }
}
