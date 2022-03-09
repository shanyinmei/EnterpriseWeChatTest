package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FileLoadTest {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public  void windowHandleTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.xpath("//*[@id='form']/span[1]/span[1]")).click();
        driver.findElement(By.xpath("//*[@class='upload-wrap']/input[1]")).sendKeys("C:/Users/sym/Desktop/picture.png");

        Thread.sleep(4000);

    }
    @AfterAll
    public static  void afterAllTest(){
        driver.quit();

    }
}
