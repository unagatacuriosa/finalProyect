package com.hiberus.cucumber.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory{
    private static PagesFactory pageFactories;

    private final WebDriver driver;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
    }
}