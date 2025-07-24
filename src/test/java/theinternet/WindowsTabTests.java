package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.NewWindow.NewWindowPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class WindowsTabTests extends TestBase {

    @BeforeEach
    public void precondition() {

        new HomePage(driver).selectMultipleWindowsLink();
    }

    @Test
    public void newTabPositiveTest() {
        new NewWindowPage(driver)
                .switchToNewTab(1)
                .verifyTabsByText("New Window");

    }

}
