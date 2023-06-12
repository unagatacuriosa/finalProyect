package com.hiberus.cucumber.stepdefs.checkout;


import com.hiberus.cucumber.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;

@Slf4j
public class CheckoutPageSteps {
    CheckoutPage checkOutPage = PagesFactory.getInstance().getCheckoutPagePage();

    @Given("The user is on the home page on checkout page")
    public void theUserIsOnTheHomePageOnChekoutPage() {
        checkOutPage.navigateTo(CheckoutPage.PAGE_URL);
    }

    @When("I should be redirected to my account page on checkout page")
    public void iShouldBeRedirectedToMyAccountPageOnCheckoutPage() {
        checkOutPage.clickMyAccount();
    }

    @And("I go to login checkout page")
    public void iGoToLoginCheckoutPage() {
        checkOutPage.clickLogin();
    }

    @And("I enter the email {string} checkout page")
    public void iEnterTheEmailCheckoutPage(String email) {
        checkOutPage.enterEmailInput(email);
    }

    @And("I enter the password on product page {string} checkout page")
    public void iEnterThePasswordOnProductPageCheckoutPage(String password) {
        checkOutPage.enterPasswordInput(password);
    }

    @And("I click on the login button on product page checkout page")
    public void iClickOnTheLoginButtonOnProductPageCheckoutPage() {
        checkOutPage.setLoginButton();
        log.info("logeado");
    }

    @And("I am back on the home page")
    public void iAmBackOnTheHomePage() {
        checkOutPage.goHome();
        log.info("home");
    }

    @And("add to cart product")
    public void addToCartProduct() {
        checkOutPage.setAddToCartButton();
        log.info("producto");
    }

    @When("I click on Checkout")
    public void iClickOn() {
        checkOutPage.goCheckout();
        log.info("checkout");
    }


    @And("I am taken to the Checkout page")
    public void iAmTakenToTheCheckoutPage() {
        String expectedURL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";
        String actualURL = checkOutPage.actualUrl();
        assertEquals(expectedURL, actualURL);
        log.info("checkoutok?");
    }


    @When("I fill in the information in the form for Step2")
    public void iFillInTheInformationInTheFormForStep2() {
        checkOutPage.setExistingAddressLabel();
        log.info("address?");
    }

    @And("I click on Continue Step2")
    public void iClickOnContinueSt2() {
        checkOutPage.setContinueButtonAddress();
        log.info("continue?");
    }

    @When("I fill in the information in the form for Step3")
    public void iFillInTheInformationInTheFormForStep3() {
        checkOutPage.setExistingBankTransferLabel();
        log.info("bank?");
    }

    @And("I accept the terms")
    public void iAcceptTheTerms() {
        checkOutPage.setCheckboxInput();
        log.info("terms?");
    }

    @And("I click on Continue Step3")
    public void iClickOnContinueSt3() {
        checkOutPage.setContinueButtonBank();
        log.info("continue?");
    }

    @Then("I verify that the amount is correct")
    public void iVerifyThatTheAmountIsCorrect() {
    }

    @Then("I verify that I am on the successful purchase page")
    public void iVerifyThatIAmOnTheSuccessfulPurchasePage() {
        String expectedText = "Your order has been placed!";
        String actualText = checkOutPage.getConfirmationMessage();
        assertEquals(expectedText, actualText);
    }

    @And("I click on Confirm Order")
    public void iClickOnConfirmOrder() {
        checkOutPage.setConfirmButton();
        log.info("confirm?");
    }
}
