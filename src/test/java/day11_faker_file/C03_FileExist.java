package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test0101(){
        System.out.println(System.getProperty("user.dir"));//C:\Users\Yasemin\IdeaProjects\com.deneme
        //bana icinde oldugum projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));//C:\Users\Yasemin
        //benim bilgisayarımın bana ozel kısmını verdi

        // C:\Users\Yasemin\IdeaProjects\com.deneme
        //C:\Users\Yasemin\Documents\Fax

        //C:\Users\ilhan\downloads
        //  //Users/apple/Downloads
        //C:\Users\HP\Downloads


        //homePath + "/Downloads"


        //Masa ustumuzdeki text dosyasının varlıgını test edelim




        /*
        Bilgisayarımızdaki bir dosyanın varlıgını test etmek icin
        once o dosyaya ulasmamız gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardır
        Her bilgisayarın kullanıcı adı farklı olacagından
        masaustu dosya yolu da birbirinden farklı olacaktır
        Testlerimizin tum bilgisayarlarda calısması icin
        dosya yolunu DİNAMİK yapmak zorundayız

        Bunun icin her bilgisayarın birbirinden farklı olan yolunu bulmak icin
         */
        String farklıKısım=System.getProperty("user.home");

        //herkesin bilgisayarında ortak olan kısım ise
        String ortakKısım="\\Desktop\\text.txt";

        String masaustuDosyaYolu=farklıKısım+ortakKısım;

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));




    }

}
