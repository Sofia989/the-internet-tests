package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.javaScriptAlerts.AlertsPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class JavaScriptAlertsTests extends TestBase {


    AlertsPage alertPage;

    @BeforeEach
    public void precondition() {

        new HomePage(driver).selectJavaScriptAlertsLink();
        alertPage = new AlertsPage(driver);

    }
    @Test
    @Tag("smoke")
    public void verifyJSAlertTextAndAccept() {
        alertPage.selectAlert()
                .verifyAlertText("I am a JS Alert")
                .acceptAlert()
                .verifyResultText("You successfully clicked an alert");

    }

    @Test
    @Tag("smoke")
    @DisplayName("Verify to -'Ok' is displayed")
    public void alertWithSelectResultTest() {
        alertPage.selectAlert()
                .acceptAlert()
                .selectResult("OK")
                .verifyResult("You clicked: Ok");

    }

    @Test
    @Tag("smoke")
    public void sendMessageToAlertTest() {
        alertPage.sendMessageToAlert("Welcome!")
                .verifyMessage("Welcome");

    }
}
