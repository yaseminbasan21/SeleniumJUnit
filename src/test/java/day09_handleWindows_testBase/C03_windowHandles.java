package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.Set;

public class C03_windowHandles {
    /*
    https://the-internet.herokuapp.com/windows adresine gidin
    Sayfadaki text'in "Opening a new window" oldugunu dogrulayın
    Sayfa baslıgının(title) "The Internet" oldugunu dogrulayın
    Click here butonuna basın
    Acılan yeni pencerenin sayfa baslıgıın "New Window" oldugunu dogrulayın
    Sayfadaki text'in "New Window" oldugunu dogrulayın
    Bir onceki pencereye geri dondukten sonra sayfa baslıgının
    "The Internet"oldugunu dogrulayın

     */
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
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki text'in "Opening a new window" oldugunu dogrulayın
        WebElement sayfadakiYazıElementi= driver.findElement(By.xpath("//h3"));
        String actualYazı= sayfadakiYazıElementi.getText();
        String expectedYazı="Opening a new window";
        Assert.assertEquals(expectedYazı,actualYazı);

        //    Sayfa baslıgının(title) "The Internet" oldugunu dogrulayın
       String actualTitle= driver.getTitle();
       String expectedTitle="The Internet";
       Assert.assertEquals(expectedTitle,actualTitle);


       /*
       eger kontrolsuz acılan bir tab veya window varsa
       o zaman sayfaların window handle degerlerini elde etmem gerekir.
       Oncelikle ikinci sayfa acılmadan once
       ilk sayfanın window handle degerini bir String'e atayalım
        */
        String ilkSayfaHandleDegeri=driver.getWindowHandle();



        //    Click here butonuna basın
        WebElement clickButonu= driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickButonu.click();



        /*
        switchTo().newWindow() demeden link tıklayarak yeni tab veya window olustugunda
        biz driver'a yeni sayfaya gec demedikce,driver eski sayfada kalır
        ve yeni sayfa ile ilgili hicbir islem yapamaz
        yeni sayfada driver'ı calıstırmak isterseniz
        once driver'ı yeni sayfaya yollamalısınız
        */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfanınHandleDegeri'ni bulmamız
        gerekir.Bunun icin driver.getWindowHandles() methodu'nu kullanarak
        acık olan tum sayfaların window handle degerlerini alıp bir set'e assign ederiz

        ilk sayfanın window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanın handle degerine esit olmayan
        ikinci sayfanın window handle degeridir deriz
         */

        //   Acılan yeni pencerenin sayfa baslıgının "New Window" oldugunu dogrulayın

        
        Set<String> windowHandleSeti=driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=each;
            }
            
        }
        //artık ikinci sayfanın window handle degerini biliyoruz
        //rahatlıkla sayfalar arası gecis yapabiliriz

          driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        String actualTitleYeni=driver.getTitle();
        String expectedTitleYeni="New Window";
        Assert.assertEquals(expectedTitleYeni,actualTitleYeni);

        //    Sayfadaki text'in "New Window" oldugunu dogrulayın
          WebElement ikinciYazıElementi=driver.findElement(By.xpath("//h3"));
          String expectedİkinciYazı="New Window";
          String actualİkinciYazı=ikinciYazıElementi.getText();
          Assert.assertEquals(expectedİkinciYazı,actualİkinciYazı);

        //    Bir onceki pencereye geri dondukten sonra sayfa baslıgının
        //    "The Internet"oldugunu dogrulayın
        driver.switchTo().window(ilkSayfaHandleDegeri);
        String ilkActualTitle=driver.getTitle();
        String ilkExpectedTitle="The Internet";
        Assert.assertEquals(ilkExpectedTitle,ilkActualTitle);
    }
}
