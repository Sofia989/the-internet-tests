package theinternet.pages.javaScriptAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;
import theinternet.pages.Frames.FramesNestedPages;
import theinternet.pages.NewWindow.NewWindowPage;
import theinternet.pages.Select.SelectMenuPage;
import theinternet.pages.interactions.DragAndDropPage;
import theinternet.pages.interactions.SliderPage;
import theinternet.pages.links.ImagesPage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//a[text()='JavaScript Alerts']")
    WebElement alertsLink;
    public AlertsPage selectJavaScriptAlertsLink() {
        click(alertsLink);

        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    WebElement newWindowsLink;
    public NewWindowPage selectMultipleWindowsLink() {
        click(newWindowsLink);

        return new NewWindowPage(driver);
    }


    @FindBy(xpath = "//a[text()='Dropdown']")

    WebElement dropDown;
    public SelectMenuPage selectDropdownLink() {
        click(dropDown);

        return new SelectMenuPage(driver);
    }


    @FindBy(xpath = "//a[text()='Nested Frames']")
    WebElement framesLink;
    public FramesNestedPages selectNestedFrames() {
        click(framesLink);
        return new FramesNestedPages(driver);

    }


    @FindBy(linkText = "Drag and Drop")
    WebElement dragAndDropLink;
    public DragAndDropPage selectDragAndDrop() {
        click(dragAndDropLink);

        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//a[text()='Horizontal Slider']")
    WebElement sliderLink;

    public SliderPage selectHorizontalSliderlink() {
        click(sliderLink);
        return new SliderPage(driver);
    }


    @FindBy(linkText="Broken Images")
    WebElement brokenImages;

    public ImagesPage selectBrokenImagesLink() {
        click(brokenImages);
        return new ImagesPage(driver);
    }
}

