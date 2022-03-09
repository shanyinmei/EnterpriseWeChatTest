package seleniumDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverTest {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
            //启动驱动
            WebDriver webDriver = new ChromeDriver();
            //打开百度
            webDriver.get("http://www.baidu.com");
            //获取标题
            String title = webDriver.getTitle();
            //打印标题
            System.out.printf(title);
            //关闭浏览器
           // webDriver.close();
        }
}
