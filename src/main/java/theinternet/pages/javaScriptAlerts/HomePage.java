package theinternet.pages.javaScriptAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;
import theinternet.pages.NewWindow.NewWindowPage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//a[text()='JavaScript Alerts']")
    WebElement alertsLink;
    public AlertsPage selectJavaScriptAlertsLink() {
        click(alertsLink);

        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    WebElement newWindowsLink;
    public NewWindowPage selectMultipleWindowsLink() {
        click(newWindowsLink);

        return new NewWindowPage(driver);
    }

    }

