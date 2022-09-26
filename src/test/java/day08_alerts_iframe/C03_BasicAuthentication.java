package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //driver.close();
    }



    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //HTML komutu:https://username:password@URL
        //Username:admin
        //password:admin
        //driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //bu sekilde girilebilir ancak
    }
}
