package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {

    // 1.Bir Class olusturun:  YoutubeAssertions
    static WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2.https://youtube.com/ adresine gidelim
        driver.get("https://www.youtube.com/");
    }

    // 3.Asagidaki adlari kullanarak 3 test methodu olusturun ve gerekli testleri yapin
    @Test
    public void titleTest(){
        //    ==> titleTest --> Sayfa basliginin "YouTube" oldugunu test edin


    }


    @Test
    public void imageTest(){
        //    ==> imageTest --> YouTube resminin goruntulendigini (isDisplayed()) test edin


    }

    @Test
    public void searchBoxTest(){
        //    ==> SearcBox in erisilebilir oldugunu test edin(isEnabled())


    }

    @Test
    public void wrongTitleTest(){
        //    ==> wrongTitleTest -->Sayfa basliginin "youtube" olmadigini dogrulayin


    }


    @After
    public void teardown(){
        driver.close();

    }

}
