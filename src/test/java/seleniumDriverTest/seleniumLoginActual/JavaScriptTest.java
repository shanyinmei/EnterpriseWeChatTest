package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.util.concurrent.TimeUnit;

public class JavaScriptTest {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public  void windowHandleTest() throws InterruptedException {
        driver.get("https://www.12306.cn/index/");

        JavascriptExecutor jsDriver= (JavascriptExecutor)driver;
        Object o = jsDriver.executeScript("return document.getElementById('train_date').value='2022-03-01'");
        jsDriver.executeScript("window.alert('祝你学业有成，拿到高薪')");
        System.out.println(o.toString());
        Thread.sleep(4000);

    }
    @AfterAll
    public static  void afterAllTest(){
        driver.quit();

    }
}
