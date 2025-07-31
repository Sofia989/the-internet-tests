package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.interactions.DragAndDropPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class DragAndDropTests extends TestBase {

    HomePage homePage;
    DragAndDropPage dragAndDrop;

    @BeforeEach
    public void precondition() {
        homePage = new HomePage(driver);
        dragAndDrop = new DragAndDropPage(driver);
        homePage.selectDragAndDrop();
    }

    //
    @Test
    public void dragBoxToBoxTest() {
        dragAndDrop.actionMoveBox()
                .verifyisBoxANowAtBoxBPosition("A");


    }

    @Test
    public void dragBoxToBoxTestWithSoftly() {
        dragAndDrop.actionMoveBox()
                .verifyisBoxANowAtBoxBPositionWithSoftly();

    }
}

