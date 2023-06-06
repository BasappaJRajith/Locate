import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String args[]) throws InterruptedException {
    WebDriver driver = null;
    String browser= "chrome";

    ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
//        ops.addArguments("--headless");
        if(browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
    }else if(browser.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
                driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobilephones");
                driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
                Thread.sleep(2000);
//                WebElement e = driver.findElement(By.xpath("(//a/span/span[2]/span[2])[2]"));
                  WebElement e = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));


                System.out.println(e.getText());


                }
                }


