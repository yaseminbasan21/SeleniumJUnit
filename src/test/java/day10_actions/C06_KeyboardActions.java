package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfa'ya gidip
        //yeni kayıt olustur butonuna basın
        //isim kutusunu locate edip,
        //geriye kalan alanları TAB ile dolasarak
        //formu doldurun

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        //geriye kalan alanları TAB ile dolasarak
        //formu doldurun

        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB) //klavye ile yana gecmemizi saglıyoe Keys TAB
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("jfdhffj@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("jfdhffj@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)//asagı ok
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                        .perform();


        Thread.sleep(5000);

    }
}
