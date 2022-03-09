package seleniumDriverTest.seleniumLoginActual;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookiesWeiXinTest {
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAllTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/sym/AppData/Local/Google/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //1.先进行人工登录企业微信并获取cookies信息存入yaml文件中
    //2.读取yaml中的cookies信息模拟登录（cookies会有个过期时间，只能是短暂性的模拟，如果过期，再次执行第一步重新获取新的cookies信息）
    @Test
    public  void weiXinWriteCookiesTest() throws IOException,InterruptedException {
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(20000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"),cookies);
    }

    @Test
    public  void weiXinReadCookiesTest() throws IOException,InterruptedException {
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //1.先进行人工登录企业微信并获取cookies信息存入yaml文件中
        //2.读取yaml中的cookies信息模拟登录（cookies会有个过期时间，只能是短暂性的模拟，如果过期，再次执行第一步重新获取新的cookies信息）
       // Thread.sleep(20000);
       // Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>() {};
        //获取cookies.xml中的cookies的值
        List<HashMap<String,Object>> cookies = (List<HashMap<String,Object>>)mapper.readValue(new File("cookies.yaml"), typeReference);

        //遍历cookies内容并让浏览器重新读取记录中的cookies
        cookies.forEach(cookie->{
            driver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
        });

        driver.navigate().refresh();

    }
    @AfterAll
    public static  void afterAllTest(){
       // driver.quit();

    }
}
