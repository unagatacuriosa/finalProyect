package com.hiberus.cucumber.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {
    private static PagesFactory pageFactories;

    private final WebDriver driver;
    private final RegisterPage registerPage;
    private final LoginPage loginPage;
    private final ProductPage productPage;
    private final CheckoutPage checkOutPage;
    private final LogoutPage logoutPage;


    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkOutPage = new CheckoutPage(driver);
        logoutPage = new LogoutPage(driver);

    }

    public static void start(WebDriver driver) {
        pageFactories = new PagesFactory(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static PagesFactory getInstance() {
        return pageFactories;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public CheckoutPage getCheckoutPagePage() {
        return checkOutPage;
    }

    public LogoutPage getLogoutPage(){return logoutPage;}
}
