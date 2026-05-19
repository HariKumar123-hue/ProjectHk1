package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ReservePage extends PageObject {

    public double chooseCheapestFlight() {

        double cheapestPrice = Double.MAX_VALUE;
        int i = 0;
        WebElementFacade cheapestButton = null;
        List<WebElementFacade> prices = findAll("//input[@type='submit']/../following-sibling::td[5]");

        for (WebElementFacade price : prices) {
            double currentPrice = Double.parseDouble(
                    price.getText().replace("$", "").replace(",", "").trim()
            );

            if (currentPrice < cheapestPrice) {
                cheapestPrice = currentPrice;
                cheapestButton = find("(//input[@type='submit'])[" + (i + 1) + "]");
            }
            i++;
        }

        if (cheapestButton == null) {
            throw new IllegalStateException("No flight rows found.");
        }

        cheapestButton.click();
        return cheapestPrice;
    }
}