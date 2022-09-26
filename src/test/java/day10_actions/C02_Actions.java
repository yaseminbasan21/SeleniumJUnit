package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon anasayfa'ya gidip
        //account menusunden create a list linkine tıklayalım
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLink= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLink).perform();

        Thread.sleep(5000);

    }
}
