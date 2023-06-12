package com.hiberus.cucumber.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hiberus.cucumber.support.Hooks.driver;

@Slf4j
public class LoginPage extends AbstractPage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/";
    @FindBy(xpath = "//ul/li/a[contains(text(), 'Login')]")
    private WebElement goLogin;
    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement dropdownMenu;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//input[contains(@value, 'Login')]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
    private WebElement successMessageElement;

    private String actualURL;

    LoginPage(WebDriver driver) {
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

    public void clickLogin() {
        log.info("Login in...");
        try {
            goLogin.click();
        } catch (TimeoutException timeoutException) {
            log.info("Timeout cliking login" + timeoutException.getClass().getSimpleName());
        }
    }

    public String actualUrl() {
        return actualURL = driver.getCurrentUrl();
    }

    public void enterEmailInput(String email) {
        enterEmail.sendKeys(email);
    }

    public void enterPasswordInput(String password) {
        enterPassword.sendKeys(password);
    }


    public void setLoginButton() {
        loginButton.click();
        log.info("continueButton");
    }

    public String getConfirmationMessage() {
        return successMessageElement.getText();
    }

    public String getErrorMessage() {
        String xpath = "//div[@class='alert alert-danger alert-dismissible']";
        WebElement errorElement = driver.findElement(By.xpath(xpath));
        return errorElement.getText();
    }


}
