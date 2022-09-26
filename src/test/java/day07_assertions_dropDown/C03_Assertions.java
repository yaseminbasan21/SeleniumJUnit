package day07_assertions_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    //Bir class olusturalım YanlısEmailTesti
    //https://automationpractice.com/index.php sayfasına gidelim
    //Sign in butonuna basalım
    //Email kutusuna @ isareti olmayan bir mail yazıp entar'a bastıgımızda
    // "Invalid email address" uyarısı cıktıgını test edelim

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement mailKutusu= driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com" + Keys.ENTER);

        WebElement uyarıYazısıElementi= driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyarıYazısıElementi.isDisplayed());
    }
}
