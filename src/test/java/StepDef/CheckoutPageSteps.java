package StepDef;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutPage;
import pages.OrderPage;
import utils.ConfigReader;

public class CheckoutPageSteps {

    private final CheckoutPage checkoutPage = new CheckoutPage(BasePage.getDriver());

    @And("user enters checkout details {string}, {string}, {string}")
    public void user_enters_checkout_details(String firstName, String lastName, String zipCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, zipCode);
    }

    @And("user completes the purchase")
    public void user_completes_the_purchase() {
        checkoutPage.finishPurchase();
    }

    @Then("order completion message should be {string}")
    public void order_completion_message_should_be(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.getOrderCompletionMessage());
        Assert.assertEquals(ConfigReader.get("DispatchMessage"), checkoutPage.getOrderDispatchMessage());
    }
}
