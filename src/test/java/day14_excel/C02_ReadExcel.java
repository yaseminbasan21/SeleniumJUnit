package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //1-Dosya yolunu bir String degiskene atayalım
          String dosyaYolu="src/resources/ulkeler (1).xlsx";

        //2-FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3-Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //4-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis); //kopyasını kod aleminde workbook a getirdik, ordan islem yapabiliyoruz

        //5-Sheet objesi olusturun workbook.getSheetAt(index)
        //6-Row objesi olusturun workbook.getSheetAt(index)
        //7-Cell objesi olusturun row.getCell(index)

        String actualData=workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();












    }

}
