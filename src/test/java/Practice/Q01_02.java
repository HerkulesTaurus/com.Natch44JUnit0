package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q01_02 {

    // .....Exercise2....

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //1-https//www.bestbuy.com a gidin
    @Before
    public void testtenOnce(){
        driver.get("https://www.bestbuy.com/");
    }

    //2-sayfa baslıgının "Best" icerdigini control edın
    @Test
    public void test01(){
    String title = driver.getTitle();
    boolean iceriyorMu = title.contains("Best");
    Assert.assertTrue("Title Best Kelimesi iceriyormu", iceriyorMu);


    }

    //3-Ayrıca relative locator kullanarak
    // ===>logoTest -------->BestBuy logosunun goruntulendıgını kontrol edın
    @Test
    public void logoTest(){
        WebElement helloHeading = driver.findElement(By.xpath("//div[text()='Hello!']"));
        WebElement logo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        boolean logoGorunuyorMu= logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
        //Assert.assertTrue(logo.isDisplayed());usttekinin aynısı

    }
    //4-Ayrıca relative locator kullanarak
    // ===>mexicoLinkTest --> Linkin goruntulendıgını kontrol edıp dogrulayın
    @Test
    public void linkTest(){
WebElement usLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink));
Assert.assertTrue(mexicoLink.isDisplayed());
    }

    @AfterClass
    public static void teardown(){
driver.quit();
    }

}
