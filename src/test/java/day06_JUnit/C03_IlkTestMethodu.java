package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C03_IlkTestMethodu {


WebDriver driver;

    @Test
    public void test01(){
        // amazon.com a gıdelim ve Title in "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com/");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

        if (actualTitle.contains(arananKelime)){
            System.out.println("amazon test PASS");
        }else{
            System.out.println("amazon test FAİLED");
        }

    }

    @Test
    public void test02() {
        // google.com a gıdelim ve Title in "google" icerdigini test edelim
        driver.get("https://www.google.com/");
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("google testi PASS");
        }else{
            System.out.println("google testi FAİLED");
        }

    }
        @Before
        public void ayarlariDuzenle(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @After
        public void ortaligiTopla(){
            driver.close();
        }

    }