package com.hiberus.cucumber.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.hiberus.cucumber.support.Hooks.driver;

@Slf4j
public class CheckoutPage extends AbstractPage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/";
    @FindBy(xpath = "//ul/li/a[contains(text(), 'Login')]")
    private WebElement goLoginButton;
    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement dropdownMenu;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//input[contains(@value, 'Login')]")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(), 'Your Store')]")
    private WebElement homeButton;
    @FindBy(xpath = "//button[contains(span, 'Add to Cart')][1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@title='Checkout']")
    private WebElement checkoutLink;
    @FindBy(xpath = "//label[contains(., 'I want to use an existing address')]")
    private WebElement existingAddressLabel;
    @FindBy(xpath = "//input[@id='button-payment-address']")
    private WebElement continueButtonAddres;
    @FindBy(xpath = "//label[contains(., 'Bank Transfer')]")
    private WebElement bankTransferLabel;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxInput;
    @FindBy(xpath = "//input[@id='button-payment-method']")
    private WebElement continueButtonBank;
    @FindBy(xpath = "//input[@id='button-confirm']")
    private WebElement confirmButton;
    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    private WebElement orderConfirmationHeader;

    private String actualURL;

    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    private void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickMyAccount() {
        log.info("Login in...");
        try {
            waitForElementClickable(dropdownMenu);
            dropdownMenu.click();
        } catch (TimeoutException timeoutException) {
            log.info("Timeout clicking login: " + timeoutException.getClass().getSimpleName());
        }
    }

    public void clickLogin() {
        log.info("Login in...");
        try {
            waitForElementClickable(goLoginButton);
            goLoginButton.click();
        } catch (TimeoutException timeoutException) {
            log.info("Timeout clicking login: " + timeoutException.getClass().getSimpleName());
        }
    }

    public void enterEmailInput(String email) {
        enterEmail.sendKeys(email);
    }

    public void enterPasswordInput(String password) {
        enterPassword.sendKeys(password);
    }

    public void setLoginButton() {
        waitForElementClickable(loginButton);
        loginButton.click();
    }

    public void goHome() {
        homeButton.click();
    }

    public void setAddToCartButton() {
        waitForElementClickable(addToCartButton);
        addToCartButton.click();
    }

    public void goCheckout() {
        waitForElementClickable(checkoutLink);
        checkoutLink.click();
    }

    public String actualUrl() {
        return actualURL = driver.getCurrentUrl();
    }

    public void setExistingAddressLabel() {
        waitForElementClickable(existingAddressLabel);
        existingAddressLabel.click();
    }

    public void setContinueButtonAddress() {
        waitForElementClickable(continueButtonAddres);
        continueButtonAddres.click();
    }

    public void setContinueButtonBank() {
        waitForElementClickable(continueButtonBank);
        continueButtonBank.click();
    }

    public void setExistingBankTransferLabel() {
        waitForElementClickable(bankTransferLabel);
        bankTransferLabel.click();
    }

    public void setCheckboxInput() {
        waitForElementClickable(checkboxInput);
        checkboxInput.click();
    }

    public void setConfirmButton() {
        waitForElementClickable(confirmButton);
        confirmButton.click();
    }

    public String getConfirmationMessage() {
        waitForElementVisible(orderConfirmationHeader);
        return orderConfirmationHeader.getText();
    }
}
