package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_01 {
    //......Exercise1....
    //1-BeforeClass ile driver i olusturun ve class icinde static yapın
    //2-maximize edin 15 sn beklet
    //3-https://www.google.com adresien gidin
    //4-arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    //5-arama kutusuna "Premnition" yazip, cıkan sonuc sayısını yazdırın
    //6-arama kutusuna "The Curios Case of Benjamin Button" yazip, cıkan sonuc sayisini yazdırın
    //7-After Class ile kapatin


    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown(){
   // driver.close();

    }

    @Before
    public void testtenOnce(){
    driver.get("https://www.google.com");

    }


    @After
    public void testtenSonra(){
        System.out.println("Sonuc yazisi :"+(driver.findElement(By.xpath("//div[@id='result-stats']")).getText()));

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile"+ Keys.ENTER);

    }

    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premnition"+Keys.ENTER);

    }


    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);

    }

}
