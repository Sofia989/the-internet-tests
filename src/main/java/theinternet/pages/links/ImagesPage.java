package theinternet.pages.links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

import java.util.Iterator;
import java.util.List;

public class ImagesPage extends BasePage {
    public ImagesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "img")
    List<WebElement> images;

    public ImagesPage checkBrokenImages() {
        System.out.println("Total images on the page:" + images.size());

        String url = "";
        Iterator<WebElement> iterator = images.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }

        for (int i = 0; i < images.size(); i++) {
            WebElement img = images.get(i);
            String imgURL = img.getAttribute("src");
            verifyLinks(imgURL);

            try {
                boolean imgDisplayed = (Boolean) js.executeScript
                        ("return (typeof arguments[0].naturalWidth !=undefined && arguments[0].naturalWidth>0);", img);

                if (imgDisplayed) {
//                    System.out.println("DISPLAY-OK");
//                    System.out.println("**********");
                    softly.assertThat(imgDisplayed);

                } else {
                    // System.out.println("DISPLAY-BROKEN");
                    softly.fail("Broken image is " + imgURL);
                }

            } catch (Exception e) {
                System.out.println("ERROR occurred");

            }
        }
        softly.assertAll();
        return this;
    }
}


