package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    //1-Bir metod olusturun:isEnabled()

    @Test
    public void enableTest(){
        //2-https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3-Textbox'ın etkin olmadıgını(enabled) dogrulayın
        WebElement enableKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled()); //enabled etkinlestirilmis demek

        //4-Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
         driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        //5-"It's enabled!" mesajının goruntulendigini dogrulayın
        WebElement itsEnabledYazıElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledYazıElementi.isDisplayed());

        //6-Textbox'ın etkin oldugunu(enable) dogrulayın
        Assert.assertTrue(enableKutusu.isEnabled());
    }
}
