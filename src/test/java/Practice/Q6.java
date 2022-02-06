package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {

//  ...Exercise6...
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com/");

        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        //    kategorilerin hepsini konsola yazdiralim
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();



// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim



    }









}
