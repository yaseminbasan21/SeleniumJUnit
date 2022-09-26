package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
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
        driver.quit(); //quit butun sayfaları kapatır
    }

    @Test
    public void test01(){
        //1-amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandle=driver.getWindowHandle();

        //2-url'in amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        //3-yeni bir pencere acıp bestbuy anasayfa'ya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri=driver.getWindowHandle();

        //4-title'ın BestBuy icerdigini test edelim
        String actualTitle=driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //5-ilk sayfaya donup sayfada java aratalım
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //6-aramada sonuclarının Java icerdigini test edelim
        WebElement sonucYazısıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazısıStr=sonucYazısıElementi.getText();
        String aradıgımızKelime="Java";
        Assert.assertTrue(sonucYazısıStr.contains(aradıgımızKelime));

        //7-yeniden bestbuy'ın acık oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        //8-logonun gorundugunu test edelim
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'][1])"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
