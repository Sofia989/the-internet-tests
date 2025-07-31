package theinternet.pages.interactions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//input[@type='range']")
    WebElement sliderInput;
    public SliderPage moveSliderInHorizontalDirection() {
        pause(1000);
        actions.dragAndDropBy(sliderInput,960,0).perform();
        return this;
    }



    @FindBy(id="range")
    WebElement sliderNumber;
    public SliderPage verifySliderText(String number) {
        Assertions.assertEquals(number,sliderNumber.getText());



        return this;
    }
}
