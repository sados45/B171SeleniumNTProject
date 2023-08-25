package day13_Excecption_ScreenShot;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException {

    WebDriver driver;

    Faker faker;

    Actions actions;


    @Test
    public void test01() {
        /*
        NULLPOINTEREXCEPTION
            Eğer bir obje yada değişken oluşturup bu oluşturduğumuz obje yada değişkene atama yapmadan
        kullanmak istersek bu exception'ı alırız
         */
        WebDriverManager.chromedriver().setup();
        /*
        Eğer driver ayarları için WebDriverManager.chromedriver().setup(); bu kodu kullanmazsak
        SESSIONNOTCREATEEXCEPTION hatasını alırız. Kullandığımız halde eğer versiyondan kaynaklı bir sorun olursa
        yine bu hatayı alırız.
         */
        driver = new ChromeDriver();
        /*
        Class seviyesinde driver objesi oluşturup atamasını yapmazsak NULLPOINTEREXCEPTION hatası alırız
         */
        driver.get("https://amazon.com");

    }

    @Test
    public void test02() {
        System.out.println(faker.name().firstName());//-->faker objesine atama yapmadığımız için NULLPOINTEREXC. aldık
    }
}