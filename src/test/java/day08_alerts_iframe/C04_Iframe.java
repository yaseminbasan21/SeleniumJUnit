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

public class C04_Iframe {
    /*
    https://the-internet.herokuapp.com/iframe adresine gidin
    Bir method olusturun
     -"An Iframe containing..." textinin erisilebilir oldugunu test edin
     ve konsolda yazdırın
     -Text Box'a "Merhaba Dunya!" yazın
     -Text Box'ın altında bulunan "Elemental Selenium"
     linkinin textinin gorunur oldugunu dogrulayın ve konsolda yazdırın
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
        driver.close();
    }

    @Test
    public void test01(){
        driver.get(" https://the-internet.herokuapp.com/iframe");

       // -"An Iframe containing..." textinin erisilebilir oldugunu test edin
       // ve konsolda yazdırın
        WebElement baslıkElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslıkElementi.isEnabled());//(enable erisilebilir demek)
        System.out.println(baslıkElementi.getText());

        //   -Text Box'a "Merhaba Dunya!" yazın
        //textbox'ı dogru olarak locate etmemize ragmen driver bulamadı
        //bunun uzerine HTML kodları inceleyince
        //textbox'ın aslında bir Iframe icerisinde oldugunu gorduk
        //bu durumda once Iframe'ı locate edip
        //switchTo() ile o Iframe'e gecmeliyiz

        WebElement IframeElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(IframeElementi);

        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();//yazılar karısmasın diye bu asamada text kutusunu temizledik
        textKutusu.sendKeys("Merhaba Dunya!");

       // -Text Box'ın altında bulunan "Elemental Selenium"
       // linkinin textinin gorunur oldugunu dogrulayın ve konsolda yazdırın

        //link yazı elementini dogru locate etmemize ragmen yazdırmadı
        //cunku yukarıda Iframe'e gecis yapmıstık
        //once oradan cıkmamız lazım
        driver.switchTo().defaultContent();//anasayfa'ya donus yapmıs olduk

        WebElement linkYazıElementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYazıElementi.isDisplayed());
        System.out.println(linkYazıElementi.getText());
    }

}
