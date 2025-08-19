package com.theinternet.runner.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import theinternet.core.TestBase;
import theinternet.pages.javaScriptAlerts.HomePage;

import java.time.Duration;


public class HomePageSteps extends TestBase {

    @Given("user opens HomePage")
    public void open_HomePage() {
        driver = new ChromeDriver();  // создаём драйвер прямо здесь
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        new HomePage(driver).openURL();
    }
}
