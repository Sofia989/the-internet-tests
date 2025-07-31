package theinternet.pages.interactions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="column-a")
    WebElement boxA;

    @FindBy(id="column-b")
    WebElement boxB;
    public DragAndDropPage actionMoveBox() {
        pause(1000);
        actions.dragAndDrop(boxA,boxB).perform();

        return this;
    }

    public DragAndDropPage verifyisBoxANowAtBoxBPosition(String text) {
        Assertions.assertTrue(shouldHaveText(boxB,text,5));
        return this;
    }

    public DragAndDropPage verifyisBoxANowAtBoxBPositionWithSoftly() {
        softly.assertThat(boxA.getText().contains("B"));
        softly.assertThat(boxB.getText().contains("A"));
        softly.assertAll();
        return this;
    }
}
