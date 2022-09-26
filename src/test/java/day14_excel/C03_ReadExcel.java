package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        //input olarak verilen
        //satır no,sutun no degerlerini parametre olarak alıp
        //o cell'deki datayı String olarak bana donduren bir method olusturun

        int satırNo=12;
        int sutunNo=2;

        //donen String'in Cezayir oldugunu test edin
        String expectedData="Baku";

       String actualData= banaDataGetir(satırNo-1,sutunNo-1);//cunku excel index ile calısır

        Assert.assertEquals(expectedData,actualData);


    }

    public static String banaDataGetir(int satırIndex, int sutunIndex) throws IOException {
       String istenenData="";

        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satırIndex)
                .getCell(sutunIndex)
                .toString();


      return istenenData;
    }


}
