package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    public LoginPage enterLoginData(String username, String password) {
        type(userNameInput, username);
        type(passwordInput, password);
        return this;
    }


    @FindBy(css = ".radius")
    WebElement loginButton;
    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return this;
    }

    @FindBy(id="flash")
    WebElement message;
    public LoginPage verifyMessage(String success) {
        assert shouldHaveText(message,success,10);
        return this;

    }
}