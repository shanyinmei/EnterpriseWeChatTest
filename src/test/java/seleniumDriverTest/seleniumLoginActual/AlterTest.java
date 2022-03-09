package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AlterTest {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public  void windowHandleTest() throws InterruptedException {
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        //一个浏览器中有多个页面时，先进入iframewrapper页面在进行操作
        driver.switchTo().frame("iframeResult");
        Actions action = new Actions(driver);
        //鼠标键盘控件最后需要加个perform链路才能使用
        action.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
        driver.switchTo().alert().accept();
        //切换到父页面去
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
        Thread.sleep(4000);

    }
    @AfterAll
    public static  void afterAllTest(){
        driver.quit();

    }
}
