package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * 显示等待和隐式等待的区别：(都是每隔0.5秒执行一次，知道超过设置的5秒还是没有获取到元素就会报错)
 * 隐式等待是1.对整个类，进行全局的的等待，2.是在服务端等待的，无法重新设置0.5秒 3.关键参数上隐式等待对超时时间可修改，间隔时间不可修改，执行过程不可修改
 * 显示等待1.是对局部的等待，2.是在客户端等待的，可以对等待条件进行灵活控制 3.关键参数上显示等待对超时时间可修改，间隔时间可修改，执行过程可修改
 */
public class Login {
    public  static WebDriver driver;
    @BeforeAll
    public  static void beforAllInit(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver  = new ChromeDriver();
        //一个页面还没有加载完全，点击发现这个元素有问题，可以采用隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest(){
       // driver.get("https://pan.baidu.com/?from=1026962h");
        driver.get("https://home.testing-studio.com");
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("1627961543@qq.com");
        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("sym19941029");
        driver.findElement(By.id("login-button")).click();


    }


    @AfterAll
    public static void beforAllEnd(){
        //driver.quit();
    }
}
