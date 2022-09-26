package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalım
        //Yuklemek istediginiz dosyayı secelim
        /*
        Bu islemi Selenium ile yapma imkanımız yok, cunku web tabanlı bir uygulama degil (click yaptıgımda failed verdi)
        bu durumda sendKeys() imdadımıza yetisir
        eger chooseFile butonuna var olan bir dosyanın dosya yolunu yollarsanız
        secme islemi otomatik olarak yapılmıs olacaktır

         */
        //1.adım choose file butonunu locate edelim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));

        //2-adım yuklenecek dosyanın dosya yolunu olusturalım
        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Desktop\\text.txt";

        String yukleneckDosya=farklıKısım+ortakKısım;

        //3.adım sendKeys ile dosya yolunu, secme butonuna yollayalım
        dosyaSecButonu.sendKeys(yukleneckDosya);

        //Upload butonuna basalım
        driver.findElement(By.id("file-submit"));
        //"File Uploaded!" textinin goruntulendigini test edelim
        WebElement yazıElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazıElementi.isDisplayed());

        Thread.sleep(5000);
    }



}
