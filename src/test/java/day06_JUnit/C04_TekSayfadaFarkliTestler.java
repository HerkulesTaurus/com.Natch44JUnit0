package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    static WebDriver driver;
    static WebElement searcBox;
    static WebElement sonucYazisiElementi;

    @Test
    public void test01(){
        // amazon sayfasında nutelle ıcın arama yapıp sonuc yazısının nutella icerdigini test edelim
        searcBox.sendKeys("nutella"+ Keys.ENTER);
        sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="nutella";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("Nutella PASS");
        }else{
            System.out.println("Nutella FAİLED");
        }
    }


    @Test
    public void test02(){
        // amazon sayfasında java ıcın arama yapıp sonuc yazısının nutella icerdigini test edelim
        searcBox=driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.clear();
        searcBox.sendKeys("java"+ Keys.ENTER);
        sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="java";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("Java PASS");
        }else{
            System.out.println("Java FAİLED");
        }

    }

    @Test
    public void test03(){
        // amazon sayfasında ali ıcın arama yapıp sonuc yazısının ali icerdigini test edelim
        searcBox=driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.clear();
        searcBox.sendKeys("ali"+ Keys.ENTER);
        sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String arananKelime="ali";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("Ali PASS");
        }else{
            System.out.println("Ali FAİLED");
        }
    }

    @BeforeClass
    public static void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");
        searcBox=driver.findElement(By.id("twotabsearchtextbox"));
    }

    @AfterClass
    public static void ortaligiTopla(){
        driver.close();
    }


}
