package day05_JUnıt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
    WebDriver driver;//yukarda olusturdum

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();//burda ayarları yaptıktan sonra
        driver = new ChromeDriver();//deger atadım
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Tum methodlardan once calısması icin yazdık
    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //before method call
        driver.get("https://www.amazon.com");
        //After method call
    }

    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }





}
