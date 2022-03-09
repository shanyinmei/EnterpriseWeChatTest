package seleniumDriverTest.seleniumLoginActual;

import org.junit.jupiter.api.Test;
import seleniumDriverTest.BaseBrowerTest;

public class BrowerTest extends BaseBrowerTest {
    @Test
    public void browerTest(){
        driver.get("https://baidu.com");
    }
}
