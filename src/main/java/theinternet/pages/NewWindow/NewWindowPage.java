package theinternet.pages.NewWindow;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class NewWindowPage extends BasePage {
    public NewWindowPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement clickLink;

    public NewWindowPage switchToNewTab(int index) {
        click(clickLink);
        return this;
    }


    @FindBy(xpath = "//div[@class='example']/h3")
    WebElement newTab;
    public NewWindowPage verifyTabsByText(String text ) {
        Assertions.assertTrue(shouldHaveText(newTab,text,5));
        //Assertions.assertTrue(newTab.getText().contains(title));
        //Assertions.assertTrue(isContainsText(title,newTab));


        return this;
    }

    private boolean isContainsText(String title, WebElement element) {
        return element.getText().contains(title);
    }

}
