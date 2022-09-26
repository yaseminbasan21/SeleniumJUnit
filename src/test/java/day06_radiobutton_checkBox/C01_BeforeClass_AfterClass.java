package day06_radiobutton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

   /*
   @BeforeClass ve @AfterClass notsyonları sadece statik method'lar icin calısır
   static bir methodun ıcerisinde static olmayan bir WebDriver kullanamayız bu yuzden
   WebDriver driver'ımızıda static yapmamız lazım
    */

    //@BeforeClass ve @AfterClass notasyonları test surecinde bir kere calısırken
    //@Before ve @After notasyonları her test method'unun basında ve sonunda calısmaktadır.
    //Hangisi daha iyi bilemeyiz onu duruma gore dusunuruz


    static WebDriver driver;//yukarda olusturdum

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();//burda ayarları yaptıktan sonra
        driver = new ChromeDriver();//deger atadım
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Tum methodlardan once calısması icin yazdık
    }
    @AfterClass
    public static void teardown(){
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
