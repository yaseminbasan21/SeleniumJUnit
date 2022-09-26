package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1-Tests package'nın altına bir class olusturalım
        //2-https://the-internet.herokuapp.com/download adresine gidelim
          driver.get("https://the-internet.herokuapp.com/download");
        //3-LambdaTest.txt dosyasını indirelim
        WebElement lambdaLinki= driver.findElement(By.xpath("//*[text()='LambdaTest.txt']"));
        lambdaLinki.click();
        Thread.sleep(5000);

        //4-dosyanın basarıyla indirilip indirilmedigini test edelim

        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Downloads\\LambdaTest.txt";

        String arananDosyaYolu=farklıKısım+ortakKısım;

        //geriye o dosya yolunun(path) var oldugunu assert etmek kaldı
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }
}
