package theinternet.pages.Select;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import theinternet.core.BasePage;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "dropdown")
    WebElement dropdown;

    public SelectMenuPage dropDownSelect(String option) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);


        return this;
    }

    public SelectMenuPage verifyOption() {
        String firstOptions = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(dropdown, firstOptions, 5));

        return this;
    }
}
