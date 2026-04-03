package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By cartItem = By.className("cart_item");
    By quantity = By.className("cart_quantity");
    By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDisplayed() {
        return driver.findElement(cartItem).isDisplayed();
    }

    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }

    public String getProductName() {
        return driver.findElement(itemName).getText();
    }
}
