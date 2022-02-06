package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti1 {
    public static void main(String[] args) {

        // 1-C01_TekrarTesti isimli bir class olusturun

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3-Cookies uyarisini kabul ederek kapatin
        // cookies icin accept tusunu locate edip kodu yazamaliyiz
        // driver.findElement(By.xpath("//div[text()=''Ich stimme zu']")).click();

        // 4-Sayfa basliginin "Google" ifadesini test edin
        String actualTitle=driver.getTitle();
        String arananKelime="Google";

        if (actualTitle.equals(arananKelime)){
            System.out.println("TİTLE test PASS");
        }else{
            System.out.println("TİTLE test FAİLED");
        }

        // 5-Arama cubuguna "Nutella" yazip aratin
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        // searchBox.submit(); da olabilir

        // 6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText());

        // 7-Sonuc sayısının 10 milyon dan fazla oldugunu test edin
        String sonucSayisiString=sonucSayisiElementi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
       // System.out.println(Arrays.toString(sonucKelimeleri));
        String sonucNutellaSayisiString=sonucKelimeleri[1];
        sonucNutellaSayisiString = sonucNutellaSayisiString.replaceAll(".", "");

        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisiString);
        if (nutellaAramaSonucu>10000000) {
            System.out.println("Arama sonuc PASS");
        }else{
            System.out.println("Arama sonuc FAİLED");
        }
        // 8-Sayfayı kapatın

        driver.close();



    }



}
