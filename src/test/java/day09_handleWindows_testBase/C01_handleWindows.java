package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();// CDwindow-C06D0109AAA406D7BD2FCD123712DEC9

        //2-nutella icin arama yaptırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        CDwindow-C06D0109AAA406D7BD2FCD123712DEC9
        bu kod acılan sayfanın unıque hash kodudur
        Selenium sayfalar arası geciste bu window handle degerini kullanır

        eger sayfalar arasında driver'ımızı gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-C06D0109AAA406D7BD2FCD123712DEC9");
        bu sayfanın window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        //3-ilk urunun resmini tıklayarak farklı bir tab olarak acın
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandıgımızda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin adımları bastan almamız gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();


        //4-yeni tab'da acılan urunun title'ını yazdırın
        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());

        //ilk sayfaya gecip url'i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());//ilk sayfa'nın url'sini verdi

    }




}
