package day13_cookies_webTables;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTable(){

        //login() metod'u olusturun ve oturum acın
        //https://www.hotelmycamp.com admin/HotalRoomAdmin adresine gidin
        //     *Username : manager
        //     *Password : Manager1!
        girisYap();

        //  table() metodu olusturun
        //       *Tum table body'sinin boyutunu(sutun sayısı) bulun. /tbody
        List<WebElement>sutunBaslıklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println(sutunBaslıklarListesi.size());//9


        //       *Table'daki tum body'i ve baslıkları(headers) konsolda yazdırın.

        //Tum body'i bir string olarak yazdırmak isterseniz,
        //body webElementini locate edip ,getText() method'u ile yazdırabilirsiniz
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());


        // printRows() metodu olusturun //tr
        //     *table body'sinde bulunan toplam satır(raw) sayısını bulun
        List<WebElement>satırlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satır sırası "+ satırlarListesi.size());


        //     *Table body'sinde bulunan satırları(rows) konsolda yazdırın
        for (WebElement each:satırlarListesi
             ) {
            System.out.println(each.getText());
        }
        //     *4. satırdaki(row) elementleri konsolda yazdırın
           List<WebElement>cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());
        }

        //    Email baslıgındaki tum elementleri(sutun) konsolda yazdırın
        // once email baslıgının kacıncı sutunda oldugunu bulalım
        List<WebElement>baslıklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i=0; i<baslıklarListesi.size();i++
             ) {
            if (baslıklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
          List<WebElement>emailSutunListesi=
                  driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
                                                              //tbody//td[3]
                                                              //dinamik hale getirdik,email yerine baska bir sutun istersek de girdigimizde calıssın diye
                                                              //td sutun

        for (WebElement each:emailSutunListesi
             ) {
            System.out.println(each.getText());
        }



    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//input[@name='UserName']"));
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


    }


}
