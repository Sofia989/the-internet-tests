package theinternet.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

@ExtendWith(TestResultLogger.class)
public class TestBase {
    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public boolean testPassed=true;
//
//    @BeforeEach
//    void startTest(TestInfo info) {
//        logger.info("Start test {}", info.getDisplayName());
//    }
//
//    @AfterEach
//    void stopTest(TestInfo info) {
//        logger.info("Stop test {}", info.getDisplayName());
//    }



    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // logger.info("Start test {} with data:{}", method.getName(), Arrays.asList(p));
    }

    @BeforeEach
    public void startTest(TestInfo testInfo){
        logger.info("Start test{} with data:{}",testInfo.getDisplayName());
    }
    @AfterEach
    public void stopTest(){

        logger.info("Stop test");
        logger.info("==================================================");
    }
}













