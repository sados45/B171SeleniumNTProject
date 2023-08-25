package day13_Excecption_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void test01() {
        /*
        STALEELEMENTREFERENCEEXCEPTION
            Locate ettiğimiz bir webelemente click yapma işleminden sonra yada bir text gönderme işleminden sonra
        navigate().refresh(),back() yada forward() methodlarını kullanırsak ve locate'ini aldığımız webelementi
        tekrar kullanmak istersek bu exception'ı alırız. Dolayısıyla bu exception'ı handle etmek için
        elementin locatini refresh(),back() yada forward() işlemlerinden sonra tekrar almamız gerekir.
            Birden fazla elementi bir list içine atıp loop içinde her birine click yapıp yine back() methodunu
        kullanırsak ilk elemente click ikinci elementi eskimiş olarak görür ve click işlemini yapmaz.
        Dolayısıyla loop içinde yeniden list elementlerinin atamasını yapmamız gerekir
        ÖRNEK:
        List<WebElement> linkler = driver.findElements(By.xpath("sdfsdf"));
        for(i=0, i<linkler.size, i++){
        linkler.get(i).click
        driver.navigate().back()
        linkler = driver.findElements(By.xpath("sdfsdf"));-->StaleElementRefenceExc. almamak için list'i tekrar tanımladık

         */
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        bekle(2);

        //ana sayfaya dönüp
        driver.navigate().back();
        bekle(2);

        //samsung aratınız
        WebElement aramaKutusuWE = driver.findElement(By.id("twotabsearchtextbox"));
        //StaleElementReferenceException hatasını handle etmek için navigate() methodundan sonra yeniden aynı locate'i kullandık
        aramaKutusuWE.sendKeys("samsung",Keys.ENTER);
    }
}