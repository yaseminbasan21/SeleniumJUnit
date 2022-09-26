package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {

    @Test
    public void webElementsSS() throws IOException {

        //amazon'a gidip Nutella aratalım
        //ve sonuc sayısının oldugu web elementin fotografını cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYazıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazıElementSS=new File("target/ekranGoruntuleri/sonucYazısıSS.jpeg");

        File temp=sonucYazıElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYazıElementSS);  //temp dosyasını asıl dosyaya kaydediyoruz


    }


}
