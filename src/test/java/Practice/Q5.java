package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {

    //  ...Exercise5...
    //  @BeforeClass ın icerisinde driver i kuralim
    //  maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
    static WebDriver driver;
    @BeforeClass
        public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

    //  Google 'a gidelim ve sayfa basliginin "Google" icerdigini dogrulayalim
    @Test
        public void test1(){
        driver.get("https://www.google.com");

        String actualTitle=driver.getTitle();
        String expectedTitle="Google";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Google iceriyor");

        }else{
            System.out.println("Title Google icermiyor");
        }

    //  Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim

    driver.get("https://www.amazon.com/");

    String actualURl = driver.getCurrentUrl();
    String expectedURL = "www.amazon.com";

    if (actualURl.contains(expectedURL)){
        System.out.println("URL iceriyor");

    }else{
        System.out.println("URL icermiyor");

        }
    }

    //  @AfterClass ta driver ı kapatalim
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
