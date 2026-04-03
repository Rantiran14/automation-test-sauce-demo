package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");
    By backHomeBtn = By.id("back-to-products");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public void fillInformation(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void clickBackHome() {
        driver.findElement(backHomeBtn).click();
    }
}
