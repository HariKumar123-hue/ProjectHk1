package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://blazedemo.com/")
public class HomePage extends PageObject {

    @FindBy(name = "fromPort")
    private WebElementFacade departureCity;

    @FindBy(name = "toPort")
    private WebElementFacade destinationCity;

    @FindBy(css = "input[type='submit']")
    private WebElementFacade findFlightsButton;

    public void openApplication() {
        open();
    }

    public void searchFlights(String from, String to) {
        departureCity.selectByVisibleText(from);
        destinationCity.selectByVisibleText(to);
        findFlightsButton.click();
    }
}
