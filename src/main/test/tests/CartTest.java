package main.test.tests;

import main.base.BaseTest;
import main.pages.LoginPage;
import main.pages.ProductsPage;
import main.pages.CartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);

        String productName = products.getFirstProductName();
        products.addFirstProductToCart();
        products.goToCart();

        CartPage cart = new CartPage(driver);

        Assertions.assertTrue(cart.isProductDisplayed());
        Assertions.assertEquals("1", cart.getQuantity());
        Assertions.assertEquals(productName, cart.getProductName());
    }
}