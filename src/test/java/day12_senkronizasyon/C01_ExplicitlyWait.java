package day12_senkronizasyon;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1-İki tane method olusturun: implicitlyWait(),explicitlyWait()
    // iki metod icinde asagıdaki adımları test edin
    @Test
    public void implicitWaitTest(){

        //2-https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3-Remove butonuna basın
         driver.findElement(By.xpath("//*[text()='Remove']")).click();

         //4-"It's gone!" mesajının goruntulendigini dogrulayın
        WebElement itsGoneYazıElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYazıElementi.isDisplayed());

        //5- Add butonuna basın
        driver.findElement(By.xpath("//*[text()='Add']")).click();


        //6-It's back mesajının gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }

    @Test
    public void explicitlyWait(){
        //2-https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3-Remove butonuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //4-"It's gone!" mesajının goruntulendigini dogrulayın
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

      /*
       WebElement itsGoneYazıElementi= driver.findElement(By.xpath("//p[@id='message']"));
       wait.until(ExpectedConditions.visibilityOf(itsGoneYazıElementi));
       Assert.assertTrue(itsGoneYazıElementi.isDisplayed());

       yazının gorunur olmasını beklerken yazının locate'ini kullanmak sorun olusturur
       cunku henuz gorunmeyen bir yazının locate edilmesi de mumkun olmayabilir
       (HTML kodları yazan developer farklı uygulamalar yapabilir
       Bu durumda bekleme islemi ve locate'i birlikte yapmalıyız
       52 ile 53'u birlestiricem

        */

        WebElement itsGoneYazıElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYazıElementi.isDisplayed());

        //5-Add butonuna basın
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //6-It's back mesajının gorundugunu test edin
        WebElement itsBackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElementi.isDisplayed());


    }




}
