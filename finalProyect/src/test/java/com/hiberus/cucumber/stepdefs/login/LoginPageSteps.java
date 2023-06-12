package com.hiberus.cucumber.stepdefs.login;


import com.hiberus.cucumber.page.LoginPage;
import com.hiberus.cucumber.page.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;

@Slf4j
public class LoginPageSteps {
    LoginPage loginPage = PagesFactory.getInstance().getLoginPage();

    @Given("I am on the home page")
    public void theUserIsOnTheHomePage() {
        log.info("the user is on the home page");
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }

    @When("I click on my account")
    public void myAccount() {
        loginPage.clickMyAccount();
    }

    @And("I click on login")
    public void goLogin() {
        loginPage.clickLogin();
    }

    @Given("I will be taken to the login screen")
    public void iAmFormLoginScreen() {
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/login";
        String actualURL = loginPage.actualUrl();
        assertEquals(expectedURL, actualURL);
    }

    @And("I enter the E-mail {string}")
    public void iEnterTheEMail(String email) {
        loginPage.enterEmailInput(email);
        System.out.println(email);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        loginPage.enterPasswordInput(password);
        System.out.println(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.setLoginButton();
    }

    @Then("I will be on the screen confirming successful login")
    public void successfulRegistration() {
        String expectedText = "My Account";
        String actualText = loginPage.getConfirmationMessage();
        assertEquals(expectedText, actualText);
    }

    @Then("an error message will appear saying {string}")
    public void anErrorMessageWillAppearSaying(String errorMessages) {
        String actualText = loginPage.getErrorMessage();
        assertEquals(errorMessages, actualText);
        System.out.println(errorMessages);
        System.out.println(actualText);
    }

}
