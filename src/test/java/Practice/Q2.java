package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {

//..Exercise2...
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//  http://www.bestbuy.com 'a gidin,
    @Before
    public void testenOnce(){
    driver.get("https://www.bestbuy.com");
    }

//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    @Test
    public void titleTest(){
        String title=driver.getTitle();
        boolean iceriyorMu = title.contains("Best");
        Assert.assertTrue("Title testi icermiyor", iceriyorMu);
    }

// 3- Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
    @Test
    public void logoTest(){
        WebElement helloHeading = driver.findElement(By.xpath("//div[text()='Hello!']"));
        WebElement logo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
       // boolean logoGorunuyorMu = logo.isDisplayed();
       // Assert.assertTrue(logoGorunuyorMu);  //alttakinin aynısı
        Assert.assertTrue(logo.isDisplayed());
    }
    //      mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    @Test
    public void linkTest(){
        WebElement usLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement chooseYazisi =  driver.findElement(By.xpath("//h1[.='Choose a country.']"));
        WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink).below(chooseYazisi));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }

    @AfterClass
    public static void teardown(){

        driver.quit();
    }

}
