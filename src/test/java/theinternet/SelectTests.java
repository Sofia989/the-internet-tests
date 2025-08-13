package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.Select.SelectMenuPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class SelectTests extends TestBase {



    SelectMenuPage selectMenu;
    @BeforeEach
    public void precondition(){
        selectMenu =new SelectMenuPage(driver);
    new HomePage(driver).selectDropdownLink();
    }

    @Test
    public void dropDownList(){
        selectMenu.dropDownSelect("Option 2")
                .verifyOption();

    }
}

