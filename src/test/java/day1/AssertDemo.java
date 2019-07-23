package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
    @Test
    public void assertNull(){
        String a=null;
        Assert.assertNull(a);
    }
    @Test
    public void assertNotNull(){
        String a=null;
        Assert.assertNotNull(a,"a为null");
    }
    @Test
    public
}
