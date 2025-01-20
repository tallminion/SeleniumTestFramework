package tallminion.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tallminion.AbstractComponents.AbstractComponents;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cart;

    @FindBy(css=".ng-animating")
    WebElement blinker;

    public void searchProductAndAddToCart(String productName){
        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    }

    By toastMessage = By.cssSelector("#toast-container");
    public void cart(){
        waitForElementToAppear(toastMessage);
        waitForElementToDisAppear(blinker);
        cart.click();
    }
}
