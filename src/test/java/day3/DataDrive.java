package day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrive {
    @DataProvider(name = "test")
    public  Object[][] data(){
        return new Object[][]{
                {"ch","aa"},
                {"2","bb"},
                {"3","cc"}
        };
    }
    @Test(dataProvider = "test")
    public void testData(String i,String j){
        System.out.print("i="+i+"和j="+j);
        System.out.print("\n");
    }
}
