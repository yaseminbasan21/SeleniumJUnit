package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {
     //basta extends yaptım ama driver gelmedi
    // sebebi baska package'da olan WebDriver'ın gelebilmesi icin
    // onu protected ya da public yapmam gerekmesi

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
