package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    @Test
    public  void windowHandleTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        String currentWindowHandle = driver.getWindowHandle();//获取 当前页面的句柄

        driver.manage().window().maximize();//窗口最大化
        driver.findElement(By.xpath("//*[@id='u1']/a[1]")).click();//点击登录
        Set<String> windowHandles = driver.getWindowHandles();//跳转注册页面后获取所有句柄

        driver.findElement(By.id("TANGRAM__PSP_11__regLink")).click();//点击注册

        //如果当前登录页面和注册页面的句柄不一致，就切换到注册页面并输入用户名和密码
        for (String win :windowHandles) {
            if(!win.equals(currentWindowHandle)){
                driver.switchTo().window(win);
                //切换另一个页面
                driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_4__userNameWrapper']/input[2]")).sendKeys("15150047373");
                driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("sym19941029");
                Thread.sleep(3000);
            }
        }
        //最后切回到登录的当前页
        driver.switchTo().window(currentWindowHandle);
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("15150047373");
        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("sym19941029");
        driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();
    }
    @AfterAll
    public static  void afterAllTest(){
        driver.quit();

    }
}
