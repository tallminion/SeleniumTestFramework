import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tallminion.pageObjects.LandingPage;
import tallminion.pageObjects.MyCart;
import tallminion.pageObjects.PaymentPage;
import tallminion.pageObjects.ProductCatalogue;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
        String productName = "BANARSI SAREE";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        driver.manage().window().maximize();

//      landing page
        LandingPage landingpage = new LandingPage(driver);
        landingpage.goTo();
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
