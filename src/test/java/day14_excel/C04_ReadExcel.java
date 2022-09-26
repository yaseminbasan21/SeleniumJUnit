package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcel() throws IOException {

        //1-Dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler (1).xlsx";

        //2-FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3-Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //4-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //ingilizce baskentler sutunu'nu yazdıralım
         int sonSatır=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatır);
        String satırdakiData="";

        for (int i = 0; i <=sonSatır ; i++) {
            satırdakiData = C03_ReadExcel.banaDataGetir(i, 1);
            System.out.println(satırdakiData);
        }
        

    }
}
