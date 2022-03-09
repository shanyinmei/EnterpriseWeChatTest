package seleniumDriverTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BaseBrowerTest {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String browser = System.getenv("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/firefoxdriver.exe");
            driver = new FirefoxDriver();
        }else if (browser.equals("safari")){//使用safari浏览器时，需要配置safaridriver --enable才能使用
            System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/safaridriver.exe");
            driver = new SafariDriver();
        }

    }
    @AfterAll
    public static  void afterAllTest(){
         driver.quit();

    }
}
