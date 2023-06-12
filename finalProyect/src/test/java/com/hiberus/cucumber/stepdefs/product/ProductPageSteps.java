package com.hiberus.cucumber.stepdefs.product;


import com.hiberus.cucumber.page.LoginPage;
import com.hiberus.cucumber.page.PagesFactory;
import com.hiberus.cucumber.page.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

@Slf4j
public class ProductPageSteps {
    ProductPage productPage = PagesFactory.getInstance().getProductPage();

    @Given("The user is on the home page on product page")
    public void theUserIsOnTheHomePageOnRegisterPage() {
        log.info("the user is on the home page");
        productPage.navigateTo(LoginPage.PAGE_URL);
    }

    @When("I should be redirected to my account page on register page")
    public void myAccountOnRegisterPage() {
        productPage.clickMyAccount();
    }

    @And("I go to login")
    public void goLogin() {
        productPage.goLogin();
    }

    @Given("I am on the form screen on register page")
    public void iAmFormScreenOnRegisterPage() {
        String expectedURL = "http://opencart.abstracta.us/index.php?route=common/home";
        String actualURL = productPage.actualUrl();
        assertEquals(expectedURL, actualURL);
    }

    @And("I enter the email {string}")
    public void iEnterTheEMail(String email) {
        productPage.enterEmailInput(email);
        System.out.println(email);
    }

    @And("I enter the password on product page {string}")
    public void iEnterThePassword(String password) {
        productPage.enterPasswordInput(password);
        System.out.println(password);
    }

    @And("I go to home page")
    public void iGoToHomePage() {
        productPage.setHomeButton();
    }

    @And("I click on the login button on product page")
    public void iClickOnLoginButtonOnProductPage() {
        productPage.setLoginButton();
    }

    @When("I click on Add to cart for the first product that appears")
    public void iClickOnForTheFirstProductThatAppears() {
        productPage.setAddToCartButton();
    }

    @And("I click to Shopping Cart")
    public void iClickToShoppingCart() {
        productPage.goToCart();
    }

    @Then("I verify that the cart count is {string}")
    public void iVerifyThatTheCartCountIs(String numItem) {
        String actualText = productPage.getNumItem();
        System.out.println(actualText);
        System.out.println(numItem);
        Assert.assertTrue(actualText.contains(numItem));
        productPage.clickRemoveButton();
    }

}
