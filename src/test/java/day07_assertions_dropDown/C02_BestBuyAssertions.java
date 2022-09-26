package day07_assertions_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    //2)https://www.bestbuy.com/ Adresine gidin
    //  farklı test method'ları olusturarak asagıdaki testleri yapın
    //  -Sayfa Url'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
    //  -titleTest => Sayfa baslıgının "Rest" icermedigini (contains) test edin
    //  -logotest => BestBuy logosunun goruntulendigini test edin
    //  -FrancaisLinkTest =>Fransızca linkin goruntulendigini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //-Sayfa Url'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String acualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,acualUrl);
    }

    @Test
    public void test02(){
        //  -titleTest => Sayfa baslıgının "Rest" icermedigini (contains) test edin
        String istenmeyenKelime="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void test03(){
        //  -logotest => BestBuy logosunun goruntulendigini test edin
        WebElement logoTest=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoTest.isDisplayed());

    }

    @Test
    public void test04(){
       // -FrancaisLinkTest =>Fransızca linkin goruntulendigini test edin
        WebElement francaisElementi=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisElementi.isDisplayed());
    }
}
