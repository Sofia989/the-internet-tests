package theinternet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class UploadFilePage extends BasePage {


    public UploadFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement uploadPicture;

    public UploadFilePage upload(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement submitButton;

    public UploadFilePage clickOnFileSubmitButton() {
        click(submitButton);
        return this;
    }

    @FindBy(css = "h3")
    WebElement confirmText;

    public UploadFilePage verifyTitle(String text) {
        Assertions.assertTrue(shouldHaveText(confirmText, text, 5));
        return this;
    }

    @FindBy(id = "uploaded-files")
    WebElement uploadedFileName;

    public UploadFilePage verifyUploadedFileName(String expectedFileName) {
        Assertions.assertTrue(uploadedFileName.getText().contains(expectedFileName));
        return this;
    }
}
