package day08_alerts_iframe;

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

public class C02_Alerts {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    Bir method olusturun:acceptAlert
      1.Butona tıklayın,uyarıdaki OK butonuna tıklayın ve result mesajının
      "You successfully clicked an alert" oldugunu test edin

    Bir method olusturun:dissmissAlert
      2.Butona tıklayın,uyarıdaki cancel butonuna tıklayın ve result mesajının
      "successfuly" icermedigini test edin.

    Bir method olusturun:sendKeysAlert
      3.Butona tıklayın,uyarıdaki metin kutusuna isminizi yazın,
      OK butonuna tıklayın ve result mesajında isminizin goruntulendigini dogrulayın

     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void acceptAlert(){
     // 1.Butona tıklayın,uyarıdaki OK butonuna tıklayın ve result mesajının
        //      "You successfully clicked an alert" oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResultYazısı="You successfully clicked an alert";
        WebElement sonucYazıElementi=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualResultYazısı=sonucYazıElementi.getText();
        Assert.assertEquals(expectedResultYazısı,actualResultYazısı);
    }

    @Test
    public void dissmissAlert(){
     //2.Butona tıklayın,uyarıdaki cancel butonuna tıklayın ve result mesajının
        //      "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfuly";
        WebElement sonucYazısıElementi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualSonucYazısı=sonucYazısıElementi.getText();
        Assert.assertFalse(actualSonucYazısı.contains(istenmeyenKelime));

    }

    @Test
    public void sendKeysAlert(){
        // 3.Butona tıklayın,uyarıdaki metin kutusuna isminizi yazın,
        //      OK butonuna tıklayın ve result mesajında isminizin goruntulendigini dogrulayın

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("yasemin");
        driver.switchTo().alert().accept(); //Ok butonuna tıklamak icin yine bunu yapmamız gerek
        WebElement sonucYazısıElemnti= driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazısıStr=sonucYazısıElemnti.getText();
        String girilenİsim="yasemin";
        Assert.assertTrue(sonucYazısıStr.contains(girilenİsim));

        System.out.println(sonucYazısıElemnti.isDisplayed()); //ben yazdım
    }

}
