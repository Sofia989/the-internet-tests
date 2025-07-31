package theinternet;

import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.interactions.SliderPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class SliderTests extends TestBase {


    HomePage homePage;

    @Test
    public void horizontalSliderTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectHorizontalSliderlink();
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .verifySliderText("5");

    }
}
