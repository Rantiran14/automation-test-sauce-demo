package main.test.tests;

import main.base.BaseTest;
import main.pages.LoginPage;
import main.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    String password = "secret_sauce";

    @Test
    public void testStandardUserLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", password);

        ProductsPage products = new ProductsPage(driver);

        Assertions.assertTrue(products.isOnProductsPage());
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void testLockedOutUser() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", password);

        String error = login.getErrorMessage();
        Assertions.assertTrue(error.contains("locked out"));
    }
}
