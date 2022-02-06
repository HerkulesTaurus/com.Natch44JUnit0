package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q4_ScrollBy {


    ////********* Note : JavaScriptExecutor nedir?
    // JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü aracılığıyla çalıştırmaya yardımcı olan bir Arayüzdür.
    // JavaScriptExecutor, javascript'i seçilen pencerede veya geçerli sayfada çalıştırmak için
    // "executescript" ve "executeAsyncScript" olmak üzere iki yöntem sunar.
    //
    //======> JavaScriptExecutor'a neden ihtiyacımız var?
    // Selenium Webdriver'da, bir web sayfasındaki işlemleri tanımlamak ve gerçekleştirmek için
    // XPath, CSS vb. gibi konum belirleyiciler kullanılır.
    // Bu konum belirleyicilerin çalışmaması durumunda JavaScriptExecutor'ı kullanabilirsiniz.
    // Bir web öğesinde istenen bir işlemi gerçekleştirmek için JavaScriptExecutor'ı kullanabilirsiniz.
    // Selenium, javaScriptExecutor'ı destekler. Ekstra bir eklenti veya eklentiye gerek yoktur.
    // JavaScriptExecutor kullanmak için komut dosyasında (org.openqa.selenium.JavascriptExecutor) içe aktarmanız yeterlidir.
    //
    //            executeScript aracılığıyla sayfayı 1000 piksel kaydırın.
    //            Javascript yöntemi ScrollBy(), web sayfasını belirli piksel sayısına kaydırır.
    //
    //            ScrollBy() yöntemlerinin sözdizimi şöyledir:
    //            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
    //            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
    //            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
    //
    //            Örnek:
    //            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır


// ...Exercise4...

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1.https://www.teknosa.com/ adresine gidiniz
        driver.get("http://www.teknosa.com");
        driver.manage().deleteAllCookies();
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications"); // pop-up ları dısable edıyor

        // 2.arama cubuguna oppo yazip enter deyiniz
        driver.findElement(By.id("search-input")).sendKeys("oppo"+ Keys.ENTER);

        // 3.sonuc sayisini yazdiriniz
        System.out.println("sonuc yazısı :"+ driver.findElement(By.className("plp-info")).getText());

        // 4.cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class ='prd-link'])[1]")).click();

        //sayfayi 100 px asagı ındırıyor
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");

        // 5.sepete ekleyiniz
        driver.findElement(By.id("addToCartButton")).click();

        // 6.sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class ='btn btn-secondary']")).click();

        // 7.consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println("siparis ozeti yazisi :"+ driver.findElement(By.className("cart-sum-title")).getText());

        // 8.Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@title ='Alışverişi Tamamla']")).click();

        // 9.son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println("hos geldiniz yazisi :"+ driver.findElement(By.xpath("//div[.='Teknosa’ya hoş geldiniz']")).getText());

        // 10.driver i kapatiniz
        driver.close();

    }
}
