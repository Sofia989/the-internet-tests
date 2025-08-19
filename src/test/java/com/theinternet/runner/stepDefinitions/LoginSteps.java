package com.theinternet.runner.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theinternet.core.TestBase;
import theinternet.pages.LoginPage;
import theinternet.pages.javaScriptAlerts.HomePage;

public class LoginSteps extends TestBase {


    @When("user clicks on the Authentication link")
    public void click_on_authentication_link(){
        new HomePage(driver).clickOnauthenticationLink();
    }

    @And("user enters correct data")
    public void enters_correct_data(){
        new LoginPage(driver).enterLoginData("tomsmith","SuperSecretPassword!");
    }

    @And("user clicks the login button")
    public void click_on_Login_button(){
        new LoginPage(driver).clickOnLoginButton();
    }

    @Then("User redirected to the secure area and verifies Success message is displayed")
    public void verify_Success_message(){
        new LoginPage(driver).verifyMessage("You logged into a secure area!");
    }
}
