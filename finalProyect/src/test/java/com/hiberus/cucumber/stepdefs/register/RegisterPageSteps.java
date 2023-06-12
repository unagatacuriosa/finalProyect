package com.hiberus.cucumber.stepdefs.register;


import com.hiberus.cucumber.page.RegisterPage;
import com.hiberus.cucumber.page.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

@Slf4j
public class RegisterPageSteps {
    RegisterPage registerPage = PagesFactory.getInstance().getRegisterPage();

    @Given("the user is on the registration confirmation page")
    public void theUserIsOnTheRegistrationConfirmationPage() {
        log.info("the user is on the home page");
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }

    @When("I click on the My Account button on the registration page")
    public void clickOnMyAccountButtonOnRegistrationPage() {
        registerPage.clickMyAccount();
    }

    @And("I click on register")
    public void register() {
        registerPage.clickRegister();
    }

    @Given("I am on the registration form screen")
    public void givenIAmOnRegistrationFormScreen() {
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/register";
        String actualURL = registerPage.actualUrl();
        assertEquals(expectedURL, actualURL);
    }

    @And("I will be enter First Name {string}")
    public void enterFirstName(String firstName) {
        registerPage.enterFirstNameInput(firstName);
    }

    @And("I will be enter Last Name {string}")
    public void enterLastName(String lastName) {
        registerPage.enterLastNameInput(lastName);
    }

    @And("I will be enter E-mail")
    public void enterEMail() {
        registerPage.enterEmail();
    }
    @And("I will be enter wrong E-mail")
    public void enterWrongEmail() {
        registerPage.enterWrongEmail();
    }

    @And("I will be enter Telephone {string}")
    public void enterTelephone(String telephone) {
        registerPage.enterTelephoneInput(telephone);
    }


    @And("I will be enter Password {string}")
    public void enterPassword(String password) {
        registerPage.enterPasswordInput(password);
    }

    @And("I will be enter Password Confirm {string}")
    public void enterPasswordConfirm(String passwordConfirm) {
        registerPage.enterPasswordConfirmInput(passwordConfirm);
    }

    @And("I accept the terms and click continue")
    public void acceptCheckPrivacyPolicy() {
//        registerPage.setCloseBitnamiButton();
        registerPage.checkPrivacyPolicyInput();
        registerPage.continueButton();
        System.out.println("buton");
    }

    @Then("I will be on the screen confirming successful registration")
    public void successfulRegistration() {
        String expectedText = "Congratulations! Your new account has been successfully created!";
        String actualText = registerPage.getConfirmationMessage();
        assertEquals(expectedText, actualText);
    }

    @Then("The {string} error message {string} should appear on the form field")
    public void errorMessagesWrongInput(String fieldName, String expectedErrorMessage) {
        String actualErrorMessage = registerPage.getErrorMessage(fieldName);
        System.out.println(actualErrorMessage);
        System.out.println(expectedErrorMessage);
        assertEquals(expectedErrorMessage, actualErrorMessage);
        log.info("mensaje de error");
    }

    @And("I will be enter E-mail {string}")
    public void iWillBeEnterEMail(String email) {
        registerPage.enterEmailInput(email);
    }

    @Given("I will be taken to the form screen")
    public void iWillBeTakenToTheFormScreen() {
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/register";
        String actualURL = registerPage.actualUrl();
        assertEquals(expectedURL, actualURL);
    }
}
