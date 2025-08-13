package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import theinternet.core.TestBase;
import theinternet.pages.Frames.FramesNestedPages;
import theinternet.pages.javaScriptAlerts.HomePage;

public class FramesNestedTests extends TestBase {


    FramesNestedPages framesNested;

    @BeforeEach
    public void precondition() {
        framesNested = new FramesNestedPages(driver);
        new HomePage(driver).selectNestedFrames();
    }

    @Test
    public void FramesByNameTests() {

        framesNested.switchToFrameTop("frame-top")
                .switchToFrameLeft("frame-left")
                .verifyFrameText("LEFT")
                .goToTop()
                .switchToFrameMiddle("frame-middle")
                .verifyFrameText("MIDDLE")
                .goToTop()
                .switchToFrameRight("frame-right")
                .verifyFrameText("RIGHT")
                .goToOutside()
                .switchToFrameBottom("frame-bottom")
                .verifyFrameText("BOTTOM");
    }

    @Test
    public void ListOfFramesTests() {
        int frames = new FramesNestedPages(driver).getNumberOfFrames();
        System.out.println("Количество фреймов на странице: " + frames);
    }

}

