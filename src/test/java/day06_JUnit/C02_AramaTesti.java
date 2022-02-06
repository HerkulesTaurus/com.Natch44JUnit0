package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //1. "https://www.saucedemo.com" adresine gidin
        driver.get("https://www.saucedemo.com");
    //2. Username kutusuna "standard_user"  yazdırın
    //driver.findElement(By.id("user-name")).sendKeys("standart_user"); --> bu sekılde kısaca oluyor
        WebElement userNameBox=driver.findElement(By.id("user-name"));
        userNameBox.sendKeys("standard_user");

    //3. Password kutuusna "secret_sauce"  yazdırın
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");

    //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

    //5. Ilk urunun ismini kaydedin ve bu urununj sayfasina gidin
        WebElement ilkUrunElementi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkurunIsmi=ilkUrunElementi.getText();
        ilkUrunElementi.click();

    //6. Add to Card butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

    //8. Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
    WebElement sepettekiUrunIsmiElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
    String sepettekiUrunIsmi=sepettekiUrunIsmiElementi.getText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        if (sepettekiUrunIsmi.equals(ilkurunIsmi)){
        System.out.println("alisveris testi PASS");
    }else{
        System.out.println("alisveris testi FAİLED");
    }

    //9. Sayfayi kapatin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    driver.close();

    }
}
