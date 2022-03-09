package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login2 {
    public  static WebDriver driver;

    public  static WebDriverWait driverWait;
    @BeforeAll
    public  static void beforAllInit(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        //显示等待
        driverWait  = new WebDriverWait(driver,5);
    }
    @Test
    public void login2Test(){
        driver.get("https://home.testing-studio.com");
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//span[contains(text(),'登录')]"));
            }
        });


    }


    @AfterAll
    public static void beforAllEnd(){
        //driver.quit();
    }
}
