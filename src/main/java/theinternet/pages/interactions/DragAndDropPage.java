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


    @FindBy(id = "column-a")
    WebElement boxA;

    @FindBy(id = "column-b")
    WebElement boxB;

    public DragAndDropPage actionMoveBox() {
        pause(1000);
        actions.dragAndDrop(boxA, boxB).perform();

        return this;
    }

    public DragAndDropPage verifyisBoxANowAtBoxBPosition(String text) {
        Assertions.assertTrue(shouldHaveText(boxB, text, 5));
        return this;
    }

    public DragAndDropPage verifyisBoxANowAtBoxBPositionWithSoftly() {
        softly.assertThat(boxA.getText().contains("B"));
        softly.assertThat(boxB.getText().contains("A"));
        softly.assertAll();
        return this;
    }

    public DragAndDropPage actionDragMeBy() {
        pause(1000);
        int xOffset1 = boxA.getLocation().getX();
        int yOffset1 = boxA.getLocation().getY();
        System.out.println("xOffset1" + xOffset1 + " yOffset1" + yOffset1);

        int xOffset = boxB.getLocation().getX();
        int yOffset = boxB.getLocation().getY();
        System.out.println("xOffset" + xOffset + " yOffset" + yOffset);
        return this;
//
//        xOffset=(xOffset-xOffset1)+20;
//        yOffset=(yOffset-yOffset1)+40;
//        actions.dragAndDropBy(boxA,xOffset,yOffset).perform();
//
//
    }}