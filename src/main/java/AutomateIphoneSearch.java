import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.function.FailableObjDoubleConsumer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomateIphoneSearch {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        String browser = "chrome";
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver(ops);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphones", Keys.ENTER);
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        Thread.sleep(2000);
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");

        }catch (Exception e){

        }
        System.out.println("Total :" + list.size());
        for(WebElement element :list){
            System.out.println(element.getText());
        }


//                      driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")).click();
//                      WebElement f =  driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));
//                      System.out.println(f.getText());



                      driver.quit();



    }
}
