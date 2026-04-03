package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By title = By.className("title");
    By firstProduct = By.cssSelector(".inventory_item:first-child button");
    By cartIcon = By.className("shopping_cart_link");
    By productName = By.cssSelector(".inventory_item_name");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnProductsPage() {
        return driver.findElement(title).getText().equals("Products");
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProduct).click();
    }

    public String getFirstProductName() {
        return driver.findElement(productName).getText();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
