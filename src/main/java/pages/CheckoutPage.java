package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebUtils;

public class CheckoutPage extends WebUtils {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.className("complete-header");
    private final By completeDispatchMessage = By.className("complete-text");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public void enterCheckoutInformation(String firstName, String lastName, String zipCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, zipCode);
        click(continueButton);
    }

    public void finishPurchase() {
        click(finishButton);
    }

    public String getOrderCompletionMessage() {
        return getText(completeHeader);
    }

    public String getOrderDispatchMessage() {
        return getText(completeDispatchMessage);
    }

}
