package day13_cookies_webTables;

public class WebTablesNot {

/*
    1-Web Tables:HTML'de bazı webelementleri organize bir sekilde,
     tablo biciminde kullanmak tercih edilebilir.

    2-Genel HTML kodları acısından tablo elementleri tag'larla belirlenmistir
      - <table>
      - <header> tablonun baslık kısmını belirler
      - <tr> veya <th> satırları
      - <td> satırdaki cell(data) numarasını verir (bunu sutun diye adlandırabiliriz ama kodlarda sutun yoktur)

      - <tbody> tablo body'si
        <tr> satırları
        <td> satırdaki cell numarasını verir (bunu sutun diye adlandırabiliriz ama kodlarda sutun yoktur)

    3-Web elementleri absolute xpath'e benzer sekilde locate edebiliriz ancak yaptıgımız
    tam olarak xpath degildir.Biz tablodaki webelementlerin tag'larına odaklanırız.

    4-Mesela      tablo body'sinin 3.satırın 5.cell'ine ulasmak istersek  //tbody//tr[3]//td[5]
                  baslıktaki ilk satırdaki tum datalar //thead//tr[1]
                  tablo body'sinde 4.sutundaki tum datalar //tbody//td[4]

    5-Eger verilen satır ve sutun numarasına gore dinamik bir locate yapmak istersek

                  "//tbody//tr["+satır+"]//td["+sutun+"]"  ??





*/







}
