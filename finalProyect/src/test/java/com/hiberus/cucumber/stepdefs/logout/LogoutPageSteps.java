package com.hiberus.cucumber.stepdefs.logout;

import com.hiberus.cucumber.page.LogoutPage;
import com.hiberus.cucumber.page.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;

@Slf4j
public class LogoutPageSteps {
    LogoutPage logoutPage = PagesFactory.getInstance().getLogoutPage();

    @Given("I am on the home page in logout")
    public void theUserIsOnTheHomePage() {
        log.info("the user is on the home page");
        logoutPage.navigateTo(logoutPage.PAGE_URL);
    }

    @When("I click on my account in logout")
    public void myAccount() {
        logoutPage.clickMyAccount();
        log.info("My Account");
    }

    @And("I click on login in logout")
    public void goLogin() {
        logoutPage.clickLogin();
    }

    @Given("I will be taken to the login screen in logout")
    public void iAmFormLoginScreen() {
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/login";
        String actualURL = logoutPage.actualUrl();
        assertEquals(expectedURL, actualURL);
    }

    @And("I enter the E-mail {string} in logout")
    public void iEnterTheEMail(String email) {
        logoutPage.enterEmailInput(email);
        System.out.println(email);
    }

    @And("I enter the password {string} in logout")
    public void iEnterThePassword(String password) {
        logoutPage.enterPasswordInput(password);
        System.out.println(password);
    }

    @And("I click on login button in logout")
    public void iClickOnLoginButton() {
        logoutPage.setLoginButton();
    }

    @Given("I will be on the screen confirming successful login in logout")
    public void successfulRegistration() {
        String expectedText = "My Account";
        String actualText = logoutPage.getConfirmationMessage();
        assertEquals(expectedText, actualText);
        log.info("loginOK");
    }

    @Then("an error message will appear saying {string}")
    public void anErrorMessageWillAppearSaying(String errorMessages) {
        String actualText = logoutPage.getErrorMessage();
        assertEquals(errorMessages, actualText);
        System.out.println(errorMessages);
        System.out.println(actualText);
    }

    @And("I click on logout")
    public void iClickOnLogout() {
        logoutPage.setLogoutLinkButton();
        log.info("logoutOK");
    }

    @Then("I will be on the screen confirming successful logout")
    public void iWillBeOnTheScreenConfirmingSuccessfulLogout() {
        String expectedText = "You have been logged off your account. It is now safe to leave the computer.";
        String actualText = logoutPage.getConfirmationMessage2();
        assertEquals(expectedText, actualText);
        log.info("comprobacionok");
    }
}
