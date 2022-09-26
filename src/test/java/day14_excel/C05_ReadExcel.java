package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {
        //1-Dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler (1).xlsx";

        //2-FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3-Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //4-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa 2'ye gidip
        //satır sayısının 24, kullanılan satır sayısının ise 12 oldugunu test edin

         int sonSatırIndex=workbook
                 .getSheet("Sayfa2")
                 .getLastRowNum();
         int expectedSatırSayısı=24;
        Assert.assertEquals(expectedSatırSayısı,sonSatırIndex+1);
        //ben de excel acılmadıgı icin,derste aslında hoca 2.sayfaya biseyler yazdı onda calısıyor
        //ama benim 2. sayfam olmadıgı icin ben de calısmıyor

        int kullanılanSatırSayısı=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        int expectedKullanılanSatırSayısı=12;
        Assert.assertEquals(expectedKullanılanSatırSayısı,kullanılanSatırSayısı);

    }
}
