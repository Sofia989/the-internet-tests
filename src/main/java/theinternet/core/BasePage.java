package theinternet.core;

import com.google.common.io.Files;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    Logger logger = LoggerFactory.getLogger(BasePage.class);

    JavascriptExecutor js;
    public static Actions actions;
    public static SoftAssertions softly;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions =new Actions(driver);
        softly=new SoftAssertions();

    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
//        public String takeScreenShot() {
//            File screenshotDir = new File(System.getProperty("user.dir") + "/src/screenshot");
//            if(!screenshotDir.exists()){
//                screenshotDir.mkdirs();
//            }
//            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File screenshot = new File(screenshotDir+"/screen-" + System.currentTimeMillis() + ".png");
//
//            try {
//                Files.copy(tmp, screenshot);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            logger.info("Скриншот сохранен в: "+screenshot.getAbsolutePath());
//            return screenshot.getAbsolutePath();
//        }

    public String takeScreenShot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(System.getProperty("user.dir") + "/src/screenshot/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }

    public WebDriverWait getWebDriverWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWebDriverWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void switchToNewWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }}







