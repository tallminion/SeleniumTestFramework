package tallminion.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tallminion.TestComponents.BaseTest;

import java.io.IOException;

public class ErrorValidation extends BaseTest {
   @Test
    public void submitOrder() throws IOException {
        String productName = "BANARSI SAREE";

        landingpage.loginApplication("sagartest1109@gmail.com", "Password123");
       Assert.assertEquals(landingpage.getErrorMessage(), "Incorrect email or password.");
    }
}
