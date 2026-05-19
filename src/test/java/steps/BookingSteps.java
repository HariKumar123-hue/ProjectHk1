package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservePage;
import utils.ConfirmationWriter;

import java.util.List;
import java.util.Map;

public class BookingSteps {

    HomePage homePage;
    ReservePage reservePage;
    PurchasePage purchasePage;
    ConfirmationPage confirmationPage;

    private String confirmationId;

    @Given("user opens travel booking application")
    public void userOpensTravelBookingApplication() {
        homePage.openApplication();
    }

    @When("user searches flights from {string} to {string}")
    public void userSearchesFlightsFromTo(String from, String to) {
        homePage.searchFlights(from, to);
    }

    @When("user selects the cheapest flight")
    public void userSelectsTheCheapestFlight() {
        double cheapestPrice = reservePage.chooseCheapestFlight();

        Serenity.recordReportData()
                .withTitle("Selected cheapest price")
                .andContents(String.valueOf(cheapestPrice));
    }

    @When("user completes purchase with:")
    public void userCompletesPurchaseWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);


        purchasePage.fillPassengerDetails(
                required(data, "name"),
                required(data, "address"),
                required(data, "city"),
                required(data, "state"),
                required(data, "zipCode"),
                required(data, "cardType"),
                required(data, "cardNumber"),
                required(data, "cardMonth"),
                required(data, "cardYear"),
                required(data, "nameOnCard")
        );
    }

    private String required(Map<String, String> data, String key) {
        String value = data.get(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing test data for key: " + key);
        }
        return value;
    }

    @Then("booking should be confirmed")
    public void bookingShouldBeConfirmed() {
        String actualMessage = confirmationPage.getConfirmationMessage();

        if (!"Thank you for your purchase today!".equals(actualMessage)) {
            throw new AssertionError("Unexpected confirmation message: " + actualMessage);
        }

        confirmationId = confirmationPage.getConfirmationId();

        if (confirmationId == null || confirmationId.isBlank()) {
            throw new AssertionError("Confirmation ID is empty");
        }
    }

    @Then("confirmation id should be saved to file")
    public void confirmationIdShouldBeSavedToFile() {
        ConfirmationWriter.saveConfirmationId(confirmationId);

        Serenity.recordReportData()
                .withTitle("Confirmation ID")
                .andContents(confirmationId);
    }
}
