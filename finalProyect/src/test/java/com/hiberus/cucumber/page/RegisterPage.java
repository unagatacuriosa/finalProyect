package com.hiberus.cucumber.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

import static com.hiberus.cucumber.support.Hooks.driver;

@Slf4j
public class RegisterPage extends AbstractPage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/";
    @FindBy(xpath = "//ul/li/a[contains(text(), 'Register')]")
    private WebElement registerButton;
    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement dropdownMenu;
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement enterFirstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement enterLastName;
    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement enterTelephone;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement enterPasswordConfirm;
    @FindBy(xpath = "//img[@id='bitnami-close-banner-button']")
    private WebElement closeBitnami;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement checkPrivacyPolicy;
    @FindBy(xpath = "//input[contains(@value, 'Continue')]")
    private WebElement continueButton;
    @FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
    private WebElement successMessageElement;
    @FindBy(xpath = "//div[@class='text-danger' and text()='First Name must be between 1 and 32 characters!']")
    private WebElement errorMessagesElement;

    private String actualURL;

    RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickMyAccount() {
        log.info("Login in...");
        try {
            dropdownMenu.click();
        } catch (TimeoutException timeoutException) {
            log.info("Timeout cliking login" + timeoutException.getClass().getSimpleName());
        }
    }

    public void clickRegister() {
        log.info("Login in...");
        try {
            registerButton.click();
        } catch (TimeoutException timeoutException) {
            log.info("Timeout cliking login" + timeoutException.getClass().getSimpleName());
        }
    }

    public String actualUrl() {
        return actualURL = driver.getCurrentUrl();
    }

    public void enterFirstNameInput(String firstName) {
        enterFirstName.sendKeys(firstName);
    }

    public void enterLastNameInput(String lastName) {
        enterLastName.sendKeys(lastName);
    }

    public void enterEmail() {
        String email = "gabiqa" + UUID.randomUUID().toString() + "@example.com";
        System.out.println(email);
        enterEmail.sendKeys(email);
    }

    public void enterWrongEmail() {
        String email = "gabiqa" + UUID.randomUUID().toString() + "example.com";
        System.out.println(email);
        enterEmail.sendKeys(email);
    }

    public void enterEmailInput(String email) {
        enterEmail.sendKeys(email);
    }

    public void enterTelephoneInput(String telephone) {
        enterTelephone.sendKeys(telephone);
    }

    public void enterPasswordInput(String password) {
        enterPassword.sendKeys(password);
    }

    public void enterPasswordConfirmInput(String passwordConfirm) {
        enterPasswordConfirm.sendKeys(passwordConfirm);
    }

    public void checkPrivacyPolicyInput() {
        checkPrivacyPolicy.click();
    }

    public void continueButton() {
        continueButton.click();
        log.info("continueButton");
    }

    public String getConfirmationMessage() {
        return successMessageElement.getText();
    }

    public String getErrorMessage(String fieldName) {
        String xpath = "//div[@class='col-sm-10']//input[@name='" + fieldName + "']/following-sibling::div[@class='text-danger']";
        WebElement errorElement = driver.findElement(By.xpath(xpath));
        return errorElement.getText();
    }


}
