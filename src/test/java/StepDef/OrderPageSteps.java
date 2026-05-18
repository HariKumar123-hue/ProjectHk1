package StepDef;

import base.BasePage;
import pages.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrderPageSteps {

    private final OrderPage orderPage = new OrderPage(BasePage.getDriver());

    @Given("User navigate to SauceDemo Application")
    public void User_navigate_to_SauceDemo_Application() {
        orderPage.navigateToApplication();
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) throws InterruptedException {
        orderPage.login(username, password);
    }

    @And("user adds {int} products to the cart")
    public void user_adds_2_products_to_the_cart(int count) {
        orderPage.addFirstNProductsToCart(count);
        Assert.assertTrue(orderPage.verifyCartIsDisplayedAsExpected(count));
    }

    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        orderPage.navigateToCartPage();
        Assert.assertEquals(orderPage.getCartBadgeCount(), orderPage.getCartItemsCount());
        orderPage.clickCheckout();
    }

    @And("cart should be empty after purchase")
    public void cart_should_be_empty_after_purchase() {
        orderPage.setBackToProduct();
        orderPage.VerifyTheCartItemIsEmpty();
    }
}