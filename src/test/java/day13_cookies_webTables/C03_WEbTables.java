package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WEbTables extends TestBase {



    @Test
    public void dinamikYazıcı() {

        //Onceki class'daki adrese gidip
        //girisYap methodu'nu kullanarak sayfaya giris yapın
        //input olarak verilen satır sayısı ve sutun sayısı'na sahip
        //cell'deki text'i yazdırın

        int satır = 3;
        int sutun = 5;

       girisYap();

       WebElement arananCell= driver.findElement(By.xpath("//thead//tr[\"+satır+\"]//td[\"+sutun+\"]"));
        //thead//tr[3]//td[5]

        System.out.println(arananCell.getText());
    }

    private void girisYap() {

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
