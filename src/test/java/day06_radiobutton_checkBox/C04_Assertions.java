package day06_radiobutton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
        driver.close();
    }

    @Test
    public void test01(){
        //Eger test methodu'muzda hicbir hatalı test yoksa, test calıstıktan sonra
        //hicbir problemle karsılasılmadıgını raporlamak icin "test passed" yazısı cıkar
        /*
          Eger testleri if ile yaparsaK
          test failed olsa bile kodlar problemsiz calıstıgı icin
          kod calısması bittiginde
          ekranın sol alt kısmında test passed yazacaktır

         */
        driver.get("https://www.amazon.com");

        //url'in https://www.facebook.com oldugunu test edin
       /*
            if (driver.getCurrentUrl().equals("https://www.facebook.com oldugunu")){
             System.out.println("url testi passed");
             }else {
             System.out.println("url testi failed");
            */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("url beklenenden farklı",expectedUrl,actualUrl);//istersek basa bir mesaj'da yazabiliriz
                                                   // bu mesaj sadece test failed olursa cıkar

        /*
        Assert ile yaptıgımız testlerde assertion failed olursa
        Java kodların calısmasını durdurur ve Assert class'ı
        bizi hata konusunda bilgilendirir

        org.junit.ComparisonFailure: url beklenenden farklı
         Expected :https://www.facebook.com
         Actual   :https://www.amazon.com/
         <Click to see difference>

         Boylece hatanın ne oldugunu arastırmamıza gerek kalmadan
         JUnit bize raporlamıs olacak
         */

        }
    }


