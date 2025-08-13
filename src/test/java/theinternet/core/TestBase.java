package theinternet.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static theinternet.core.ApplicationManager.stopDriver;

//@ExtendWith(TestResultLogger.class)
public class TestBase {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    protected static WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public boolean testPassed = true;
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
    public void setUp(TestInfo testInfo) {
        driver = app.startTest();
        logger.info("Start test {} with data:{}", testInfo.getDisplayName());
    }

    @AfterEach
    public void stopTest() {

        logger.info("Stop test");
        logger.info("==================================================");
    }

    @AfterAll
    public static void tearDown() {
        stopDriver();
    }
}
