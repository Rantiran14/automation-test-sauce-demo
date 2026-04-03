package main.test.tests;

import main.base.BaseTest;
import main.pages.LoginPage;
import main.pages.ProductsPage;
import main.pages.CartPage;
import main.pages.CheckoutPage;
import main.utils.DataUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {

        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add product
        ProductsPage products = new ProductsPage(driver);
        products.addFirstProductToCart();
        products.goToCart();

        // Go to checkout
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.clickCheckout();

        // Fill random data
        String firstName = DataUtil.randomString(5);
        String lastName = DataUtil.randomString(5);
        String postalCode = DataUtil.randomNumber(5);

        checkout.fillInformation(firstName, lastName, postalCode);
        checkout.clickContinue();
        checkout.clickFinish();

        // Assertions
        Assertions.assertEquals("Thank you for your order!", checkout.getSuccessMessage());

        // Back to home
        checkout.clickBackHome();

        // Verify redirect
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
}
