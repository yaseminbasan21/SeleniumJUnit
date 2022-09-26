package day08_alerts_iframe;

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

public class C01_Alerts {

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
        //herhangi bir web sitesine gidince veya
        //bir websitesine herhangi bir islem yaptıgımızda ortaya cıkan
        //uyarılara alert diyoruz

        //Eger bir alert inspect yapılabiliyorsa,o alert otomasyon ile kullanılabilir,
        //bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        //tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz

        //Ancak web uygulamalarında HTML alert yanında java script alert de bulunabilir
        //js alert'ler locate edilemez
        //Selenium'da js alert'ler icin ozel bir yontem gelistirilmistir

         driver.get("https://the-internet.herokuapp.com/javascript_alerts");
         driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

         //alert'te OK tusuna basın
        driver.switchTo().alert().accept();

        //result kısmında "You successfully clicked an alert" yazdıgını test edin

        String expectedResult="You successfully clicked an alert";
        WebElement sonucYazıElementi=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualResultYazısı=sonucYazıElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazısı);
    }

}
