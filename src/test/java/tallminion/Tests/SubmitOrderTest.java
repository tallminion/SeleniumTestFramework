package tallminion.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tallminion.TestComponents.BaseTest;
import tallminion.pageObjects.LandingPage;
import tallminion.pageObjects.MyCart;
import tallminion.pageObjects.PaymentPage;
import tallminion.pageObjects.ProductCatalogue;

import java.io.IOException;
import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class SubmitOrderTest extends BaseTest {
   @Test
    public void submitOrder() throws IOException {
        String productName = "BANARSI SAREE";

        LandingPage landingpage = launchApplication();
        landingpage.loginApplication("sagartest1109@gmail.com", "Password123");

//      Product catalogue
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.searchProductAndAddToCart(productName);
        productCatalogue.cart();

//      checkout page
        MyCart mycart = new MyCart(driver);
        mycart.checkout(productName);

//      payment page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setCountryAndPlaceOrder();

        driver.quit();

    }
}
