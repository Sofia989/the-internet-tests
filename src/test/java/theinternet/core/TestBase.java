package theinternet.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class TestBase {
    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // logger.info("Start test {} with data:{}", method.getName(), Arrays.asList(p));
    }


    }





