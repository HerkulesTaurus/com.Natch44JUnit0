package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {

    // 1. Bir Calss olusturun BestBuyAssertions
    static WebDriver driver;
    @BeforeClass
    public static void sutUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void urlTesti(){
        // 2. https://www.bestbuy.com/ adresine gidin farkli test methodlari olusturarak asagidaki testleri olusturun

        //--> sayfa URL ini https://www.bestbuy.com/ a esit oldugunu test edin
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";

        Assert.assertEquals( "Lutfen test degerlerini gozden gecirin" ,expectedURL,actualURL);
    }

    @Test
    public void titleTesti(){
        //--> titletest ==> sayfa basslıgının "Rest" icermedigini (contains) test edin
        String actualTitle=driver.getTitle();
        String istenmeyenKelime="Rest";

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
        System.out.println("bu satır calsıır");
    }

    @Test
    public void logoTesti(){
        //--> logoTest  ==> Bestbuy logosunun goruntulandıgını test edın
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logoElementi.isDisplayed());
    }

    @Test
    public void francaisTesti(){
        //--> FrancaisLinkTest ==> fransızca linkin goruntulendıgını test edın
        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francais.isDisplayed());

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }


}
