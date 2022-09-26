package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void cookiesTesti(){
        //1-Amazon anasayfa'ya gidin
        driver.get("https://www.amazon.com");

        //2-Tum cookie'leri listeleyin
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(sayac+".ci cookie: " +each);
            System.out.println("name :" +each.getName());
            System.out.println("value :" +each.getValue());
            sayac++;
        }
           /*
           [sp-cdn="L5Z9:TR"; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;, i18n-prefs=USD; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com, ubid-main=132-8405683-6151853; expires=Cmt, 10 Haz 2023 05:34:30 EET; path=/; domain=.amazon.com;secure;, session-id-time=2082787201l; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;, skin=noskin; path=/; domain=.amazon.com, session-token="BNVryiaIie8jPHWDWL81JzKdBVtkJ1pIcLRx/sWld66qxQi+lZ/Xn9ke9JJDlFfjEqtmBWDSeqFQkapk/Qfdqn0mQ0Uz/m6eSyaE2eM5xCEPM6ogiVCFJCEI/AmLe+IiOvAuXfcBTDDA5MUIEHY0ZbEfxR2eLE2Xr4ddHSDjex/ZHdB5GYO1XDdlzbd/0EXUpx4F+hbIZhvbCmaXLfOWGw=="; expires=Cmt, 10 Haz 2023 05:34:31 EET; path=/; domain=.amazon.com;secure;, csm-hit=tb:s-P545S9JE8VTAKJ9ATP7Q|1654871669963&t:1654871671008&adb:adblk_no; expires=Cum, 26 May 2023 05:34:31 EET; path=/; domain=www.amazon.com, session-id=139-0149311-4324757; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;]
1.ci cookie: sp-cdn="L5Z9:TR"; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;
name :sp-cdn
value :"L5Z9:TR"
2.ci cookie: i18n-prefs=USD; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com
name :i18n-prefs
value :USD
3.ci cookie: ubid-main=132-8405683-6151853; expires=Cmt, 10 Haz 2023 05:34:30 EET; path=/; domain=.amazon.com;secure;
name :ubid-main
value :132-8405683-6151853
4.ci cookie: session-id-time=2082787201l; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;
name :session-id-time
value :2082787201l
5.ci cookie: skin=noskin; path=/; domain=.amazon.com
name :skin
value :noskin
6.ci cookie: session-token="BNVryiaIie8jPHWDWL81JzKdBVtkJ1pIcLRx/sWld66qxQi+lZ/Xn9ke9JJDlFfjEqtmBWDSeqFQkapk/Qfdqn0mQ0Uz/m6eSyaE2eM5xCEPM6ogiVCFJCEI/AmLe+IiOvAuXfcBTDDA5MUIEHY0ZbEfxR2eLE2Xr4ddHSDjex/ZHdB5GYO1XDdlzbd/0EXUpx4F+hbIZhvbCmaXLfOWGw=="; expires=Cmt, 10 Haz 2023 05:34:31 EET; path=/; domain=.amazon.com;secure;
name :session-token
value :"BNVryiaIie8jPHWDWL81JzKdBVtkJ1pIcLRx/sWld66qxQi+lZ/Xn9ke9JJDlFfjEqtmBWDSeqFQkapk/Qfdqn0mQ0Uz/m6eSyaE2eM5xCEPM6ogiVCFJCEI/AmLe+IiOvAuXfcBTDDA5MUIEHY0ZbEfxR2eLE2Xr4ddHSDjex/ZHdB5GYO1XDdlzbd/0EXUpx4F+hbIZhvbCmaXLfOWGw=="
7.ci cookie: csm-hit=tb:s-P545S9JE8VTAKJ9ATP7Q|1654871669963&t:1654871671008&adb:adblk_no; expires=Cum, 26 May 2023 05:34:31 EET; path=/; domain=www.amazon.com
name :csm-hit
value :tb:s-P545S9JE8VTAKJ9ATP7Q|1654871669963&t:1654871671008&adb:adblk_no
8.ci cookie: session-id=139-0149311-4324757; expires=Cmt, 10 Haz 2023 05:34:29 EET; path=/; domain=.amazon.com;secure;
name :session-id
value :139-0149311-4324757
            */



        //3-Sayfadaki cookies sayısının 5'den buyuk oldugunu test edin
        int cookieSayısı=cookiesSet.size();
        Assert.assertTrue(cookieSayısı>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each:cookiesSet
             ) {
             if (each.getName().equals("i18n-prefs")){
                 Assert.assertEquals("USD",each.getValue());
             }
        }


        //5-ismi "en sevdigim cookie" ve degeri "cıkolatalı" olan bir cookie olusturun ve sayfaya ekleyin

        Cookie cookie=new Cookie("en sevdigim cookie","cikolatalı");
        driver.manage().addCookie(cookie);
        sayac=1;
        cookiesSet=driver.manage().getCookies();
        for (Cookie each:cookiesSet
             ) {
            System.out.println(sayac+".ci cookie "+each);
            sayac++;
        }


        //6-eklediginiz cookie'nın sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(cookie));


        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());
    }
}
