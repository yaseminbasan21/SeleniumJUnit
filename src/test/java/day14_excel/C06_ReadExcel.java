package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasındaki tum verileri classımıza alıp
        //bir java objesine store edelim
        //boylece her seferinde excel'e ulasıp satır,sutun vs.. ugrasmayalım

        //Database yapısında olan excel'i
        //koyabilecegimiz en uygun Java obje'si map'dir


        Map<String,String>ulkelerMap=new HashMap<>();

        //1-Dosya yolunu bir String degiskene atayalım
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        //2-FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //3-Workbook objesi olusturalım, parameter olarak fileInputStream objesini girelim
        //4-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);


        //for loop olusturup tum degerleri Map'in icine atmalıyız

        int sonSatırIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatırIndex ; i++) {
          //key i. satırdaki 0 index'indeki data olacak
            String key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();


            //value ise i. satırdaki 1,2 ve 3. index'teki dataların birlesimi olacak

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

            System.out.println(ulkelerMap);

            //Listede Ghana oldugunu test edelim

           // Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));

        }
        
        
    }
}
