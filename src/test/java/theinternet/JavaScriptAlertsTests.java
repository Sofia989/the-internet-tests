package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    public void verifyJSAlertTextAndAccept() {
        alertPage.selectAlert()
                .verifyAlertText("I am a JS Alert")
                .acceptAlert()
                .verifyResultText("You successfully clicked an alert");

    }

    @Test
    @DisplayName("Verify to -'Ok' is displayed")
    public void alertWithSelectResultTest() {
        alertPage.selectAlert()
                .acceptAlert()
                .selectResult("OK")
                .verifyResult("You clicked: Ok");

    }

    @Test
    public void sendMessageToAlertTest() {
//        alertPage.selectAlert()
//                .acceptAlert();
        alertPage.sendMessageToAlert("Welcome!")
                .verifyMessage("Welcome");

    }
}
