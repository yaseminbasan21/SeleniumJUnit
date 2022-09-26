package day06_radiobutton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin (ben de cıkmadı o yuzden pas geciyorum)

        //Yeni hesap olustur'a tıkla
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //"radio buttons" elementlerini locate edin
        WebElement femaleButton=driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement maleButton=driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement customButton=driver.findElement(By.xpath("//*[text()='Özel']"));

        //Secili degilse cinsiyet butonundan size uygun olanı secin
        Thread.sleep(3000);
        if (!femaleButton.isSelected()){
            femaleButton.click();
        }
        Thread.sleep(3000);


    }

    //RadioButton ile Checkbox'ın farkı, RadioButton da sadece 1 isaretleme yapabiliyoruz,
    //CheckBox'da ise 1'den fazla isaretleme yapılabilir
}
