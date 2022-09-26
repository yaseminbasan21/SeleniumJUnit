package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {

   /*
        GET SCREENSHOT
        1.Adım: Bir TakeScreenShot objesi olusturup
         driver'ımızı TakeScreenshot'a cast yapalım

        2.Adım:Kaydettigimiz ekran goruntusunu proje'de
        istedigimiz yere kaydedebilmek icin path ile
        yeni bir File olusturalım

        3.Adım:Takescreenshot objesini kullanarak getScreenshotAs()
        methodu'nu calıstıralım ve gelen resmi
        gecici bir file'a assign edelim

    */



    @Test
    public void tumSayfa() throws IOException {

        //amazon sayfasına gidip tum sayfanın fotografını cekelim

        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;


        LocalDateTime date=LocalDateTime.now();

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih= date.format(dtf);


        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaResim);

    }




}
