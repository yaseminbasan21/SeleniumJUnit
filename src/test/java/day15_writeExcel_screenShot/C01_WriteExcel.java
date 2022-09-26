package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        //1)Yeni bir Class olusturalım WriteExcel
        //2)Yeni bir test method olusturalım writeExcelTest()

        //3)Adımları takip ederek 1. satıra kadar gidelim
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu); //git su dosya yolundaki dosyayı bulup oku
        Workbook workbook= WorkbookFactory.create(fis); //kullanabilmek icin icinde bulundugumuz class'a getirmemiz lazım

        //4)5.hucreye yeni bir cell olusturalım
        //5)Olusturdugumuz hucreye "Nufus" yazdıralım
        workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4).setCellValue("Nufus");  //ındex'e gore yazıyoruz

        //6)2. satır nufus kolonuna 1500000 yazdıralım
        workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(3).setCellValue("1500000");

        //7)10. satır nufus kolonuna 250000 yazdıralım
        workbook
                .getSheet("Sayfa1")
                .getRow(9)
                .createCell(4).setCellValue("250000");

        //8)15. satır nufus kolonuna 54000 yazdıralım
        workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .createCell(4).setCellValue("54000");

        //9)Dosyayı kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //10)Dosyayı kapatalım
        workbook.close();
        fis.close();
        fos.close();







    }




}
