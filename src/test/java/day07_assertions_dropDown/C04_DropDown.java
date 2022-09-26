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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {

    /*
    amazon'a gidip
    dropdown'dan books secenegini secip
    Java aratalım
    ve arama sonuclarının Java icerdigini tespit edelim
     */
    WebDriver driver;

    @Before
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
       driver.quit();
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //dropdown'dan bir option secmek icin 3 adım vardır
        //1-dropdown'ı locate edelim

        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Bir select objesi olusturup
        //parametre olarak bir onceki adımda locate ettigimiz ddm'yi girelim

        Select select=new Select(dropDownMenu);

        //3-Dropdown'da var olan option'lardan istedigimiz bir taneyi secelim

         select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        //arama kutusuna Java Yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        Thread.sleep(5000);

        //arama sonuclarının Java icerdigini tespit edelim
        WebElement sonucYazısıElement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazısıStr=sonucYazısıElement.getText();
        String arananKelime="Java";

        Assert.assertTrue(sonucYazısıStr.contains(arananKelime));

        Thread.sleep(5000);

    }
}
