package theinternet.pages.javaScriptAlerts;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theinternet.core.BasePage;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='example']//button)[1]")
    WebElement alertButton;

    public AlertsPage selectAlert() {
        click(alertButton);

        return this;
    }

    public AlertsPage verifyAlertText(String expectedText) {
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    @FindBy(id = "result")
    WebElement resultMessage;

    public AlertsPage acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public AlertsPage verifyResultText(String expectedText) {
        Assertions.assertEquals(expectedText, resultMessage.getText());
        return this;

    }

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement confirmResult;

    public AlertsPage selectResult(String result) {
        click(confirmResult);
        if(result!=null&&result.equals("OK")){
            driver.switchTo().alert().accept();
        }else if(result!=null&&result.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWebDriverWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebDriverWait getWebDriverWait(int time) {

        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(shouldHaveText(resultMessage, text, 10));
        return this;

    }

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement promptButton;

    public AlertsPage sendMessageToAlert(String message) {
        click(promptButton);
        if(message!=null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;

    }


@FindBy(id="result")
WebElement result;
    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(shouldHaveText(result,text,10));

        return this;
    }
}
