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
public class ProductPage extends AbstractPage {
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
    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private WebElement cartButton;
    @FindBy(xpath = "(.//button[contains(@class, 'btn-danger')])[2]")
    private WebElement removeButton;

    private String actualURL;

    ProductPage(WebDriver driver) {
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

    public void goLogin() {
        log.info("Login in...");
        try {
            goLoginButton.click();
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
    }

    public void setAddToCartButton() {
        addToCartButton.click();
    }

    public void setHomeButton() {
        homeButton.click();
    }

    public String getNumItem() {
        WebElement quantityInputElement = driver.findElement(By.xpath("(//input[contains(@name, 'quantity')])[1]"));
        return quantityInputElement.getAttribute("value");
    }


    public void goToCart() {
        cartButton.click();
    }
    public void clickRemoveButton() {
        removeButton.click();
    }


}
