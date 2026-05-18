package pages;

import base.BasePage;
import org.junit.Assert;
import utils.ConfigReader;
import utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends WebUtils {

    private final WebDriver driver = BasePage.getDriver();
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By addToCartButtons = By.cssSelector("button[id^='add-to-cart']");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartItems = By.className("cart_item");
    private final By CartBtn = By.className("shopping_cart_link");
    private final By checkoutButton = By.id("checkout");
    private final By backToProduct = By.id("back-to-products");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToApplication() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public void addFirstNProductsToCart(int count) {
        for (int i = 0; i < count; i++) {
            List<WebElement> buttons = driver.findElements(addToCartButtons);
            buttons.get(i).click();
        }
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(getText(cartBadge));
    }

    public boolean verifyCartIsDisplayedAsExpected(int count) {
        return getCartBadgeCount() == count;
    }

    public void navigateToCartPage() {
        click(CartBtn);
    }
    public void clickCheckout() {
        click(checkoutButton);
    }

    public int getCartItemsCount() {
        return getElementsCount(cartItems);
    }

    public void VerifyTheCartItemIsEmpty() {
        Assert.assertEquals(0, getCartItemsCount());
    }

    public void setBackToProduct() {
        click(backToProduct);
    }
}