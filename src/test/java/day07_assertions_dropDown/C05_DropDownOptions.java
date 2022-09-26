package day07_assertions_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {

    /*
    Amazon anasayfa'ya gidip
    dropdown menuden Books'u secelim
    sectigimiz option'ı yazdıralım

    dropdown'daki opsiyonların toplam sayısının
    28 oldugunu test edin
     */

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
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']")); //locate ediyorum
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Books");

       //bir dropdown ile calısıyorken, son secilen option'a ulasmak isterseniz
        // select.getFirstSelectedOption() methodu'nu kullanmalısınız
        // bu method bize WebElement dondurur,(referans)
        //uzerindeki yazıyı yazdırmak icin getText() unutulmamalıdır
        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown'daki opsiyonların toplam sayısının
        //    28 oldugunu test edin

       List<WebElement>optionList = select.getOptions();

       int actualOptionSayısı= optionList.size();
       int expectedOptionsayısı=28;
        Assert.assertEquals(expectedOptionsayısı,actualOptionSayısı);

    }

}
