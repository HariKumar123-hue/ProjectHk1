package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends PageObject {

    @FindBy(id = "inputName")
    private WebElementFacade inputName;

    @FindBy(id = "address")
    private WebElementFacade address;

    @FindBy(id = "city")
    private WebElementFacade city;

    @FindBy(id = "state")
    private WebElementFacade state;

    @FindBy(id = "zipCode")
    private WebElementFacade zipCode;

    @FindBy(id = "cardType")
    private WebElementFacade cardType;

    @FindBy(id = "creditCardNumber")
    private WebElementFacade creditCardNumber;

    @FindBy(id = "creditCardMonth")
    private WebElementFacade creditCardMonth;

    @FindBy(id = "creditCardYear")
    private WebElementFacade creditCardYear;

    @FindBy(id = "nameOnCard")
    private WebElementFacade nameOnCard;

    @FindBy(css = "input[type='submit']")
    private WebElementFacade purchaseButton;

    public void fillPassengerDetails(
            String passengerName,
            String passengerAddress,
            String passengerCity,
            String passengerState,
            String passengerZip,
            String passengerCardType,
            String passengerCardNumber,
            String passengerCardMonth,
            String passengerCardYear,
            String passengerNameOnCard
    ) {
        inputName.type(passengerName);
        address.type(passengerAddress);
        city.type(passengerCity);
        state.type(passengerState);
        zipCode.type(passengerZip);
        cardType.selectByVisibleText(passengerCardType);
        creditCardNumber.type(passengerCardNumber);
        creditCardMonth.clear();
        creditCardMonth.type(passengerCardMonth);
        creditCardYear.clear();
        creditCardYear.type(passengerCardYear);
        nameOnCard.type(passengerNameOnCard);
        purchaseButton.click();
    }
}
