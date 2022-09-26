package day07_assertions_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    //https://the-internet.herokuapp.com/dropdown adresine gidin
    //  1.Index kullanarak secenek 1'i (Option 1) secin ve yazdırın
    //  2.Value kullanarak secenek 2'yi (Option 2) secin ve yazdırın
    //  3.Visible Text(gorunen metin) kullanarak Secenek 1'i (Option 1) secin ve yazdırın
    //  4.Tum dropDown options'ı yazdırın
    //  5.Dropdown'un boyutunu bulun, Dropdown'da 4 oge varsa konsolda true
    // degilse false yazdırın

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
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //  1.Index kullanarak secenek 1'i (Option 1) secin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']")); //dropdown'ı locate etmek icin bu yeterli degil select objesi de olusturmamız gerekiyordu
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //  2.Value kullanarak secenek 2'yi (Option 2) secin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //  3.Visible Text(gorunen metin) kullanarak Secenek 1'i (Option 1) secin ve yazdırın
         select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //  4.Tum dropDown options'ı yazdırın
        List<WebElement> tumOpsiyonlar=select.getOptions();
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        //  5.Dropdown'un boyutunu bulun, Dropdown'da 4 oge varsa konsolda true
        // degilse false yazdırın

        int dropDownBoyut=tumOpsiyonlar.size();
        if (dropDownBoyut==4){
            System.out.println("true");
        }else {
            System.out.println("false");
        }



        /*
        Option 1
Option 2
Option 1
Please select an option
Option 1
Option 2
false

         */


    }




}
