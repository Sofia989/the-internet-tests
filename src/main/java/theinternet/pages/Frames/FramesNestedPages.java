package theinternet.pages.Frames;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class FramesNestedPages extends BasePage {
    public FramesNestedPages(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//frame[@name='frame-top']")
    WebElement top;

    public FramesNestedPages switchToFrameTop(String s) {
        driver.switchTo().frame(top);

        return this;
    }


    @FindBy(xpath = "//frame[@name='frame-left']")
    WebElement left;

    public FramesNestedPages switchToFrameLeft(String s) {
        driver.switchTo().frame(left);
        return this;
    }

    @FindBy(xpath = "/html/body")
    WebElement body;

    public FramesNestedPages verifyFrameText(String text) {
        System.out.println("BODY TEXT: " + body.getText());

        Assertions.assertTrue(shouldHaveText(body, text, 5));

        return this;
    }


    public FramesNestedPages goToTop() {
        driver.switchTo().parentFrame();
        return this;
    }


    @FindBy(xpath = "//frame[@name='frame-middle']")
    WebElement middle;

    public FramesNestedPages switchToFrameMiddle(String text) {
        driver.switchTo().frame(middle);

        return this;
    }


    @FindBy(xpath = "//frame[@name='frame-right']")
    WebElement right;

    public FramesNestedPages switchToFrameRight(String text) {
        driver.switchTo().frame(right);

        return this;
    }

    public FramesNestedPages goToOutside() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = " //frame[@name='frame-bottom']")
    WebElement bottom;

    public FramesNestedPages switchToFrameBottom(String text) {
        driver.switchTo().frame(bottom);

        return this;
    }
    public int getNumberOfFrames() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((Long) js.executeScript("return window.length")).intValue();
    }

}
