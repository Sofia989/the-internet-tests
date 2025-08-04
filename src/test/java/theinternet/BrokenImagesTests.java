package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.javaScriptAlerts.HomePage;
import theinternet.pages.links.ImagesPage;

public class BrokenImagesTests extends TestBase {



    HomePage homePage;
    ImagesPage images;
    @Test
    public void checkBrokenImagesTest(){
        homePage=new HomePage(driver);
        images =new ImagesPage(driver);
        homePage.selectBrokenImagesLink();
        images.checkBrokenImages();

    }
}



