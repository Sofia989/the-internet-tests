package theinternet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.UploadFilePage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class UploadFileTests extends TestBase {


    UploadFilePage uploadFile;

    @BeforeEach
    public void precondition() {
        uploadFile = new UploadFilePage(driver);
        new HomePage(driver).selectUploadFile();

    }

    @Test
    public void uploadFileByTextAfterUploadTest() {
        uploadFile.upload("C:/Tools/filmIcon.png")
                .clickOnFileSubmitButton()
                .verifyTitle("File Uploaded!")
        ;
    }

    @Test
    public void uploadFileByNameFileTest() {
        uploadFile.upload("C:/Tools/filmIcon.png")
                .clickOnFileSubmitButton()
                .verifyUploadedFileName("filmIcon.png")
        ;
    }
}
