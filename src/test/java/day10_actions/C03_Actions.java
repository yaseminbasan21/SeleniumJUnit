package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //1-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //2-Cizili alan uzerinde sag click yapalım
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //3-Alert'te cıkan yazının "You selected a context menu" oldugunu test edelim
        String expectedYazı="You selected a context menu";
        String actualYazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazı,actualYazı);

        //4-Tamam diyerek alert'i kapatalımm
        driver.switchTo().alert().accept();

        //5-Elemental Selenium linkine tıklayalım
        String ilkSayfaWHDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWHDegeri);
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String>handleSeti=driver.getWindowHandles();
        String ikinciSayfaWHDegeri="";
        for (String each:handleSeti
             ) {
            if (!each.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }
        System.out.println(ikinciSayfaWHDegeri); //34'ten 43'e kadarki yeri driver'ı da ikinci sayfaya yollamak icindi


        //6-Acılan sayfada h1 tagında "Elemental Selenium" yazdıgını test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri);
        WebElement yazıElementi= driver.findElement(By.tagName("h1"));
        String expectedİkinciYazı="Elemental Selenium";
        String actualİkinciYazı=yazıElementi.getText();
        Assert.assertEquals(expectedİkinciYazı,actualİkinciYazı);

    }
}
