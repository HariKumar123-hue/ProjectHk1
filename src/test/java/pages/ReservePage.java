package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ReservePage extends PageObject {

   public double chooseCheapestFlight() {
        List<WebElementFacade> buttons = findAll("//input[@type='submit']");
        List<WebElementFacade> priceCells = findAll("//input[@type='submit']/../following-sibling::td[5]");

        double cheapestPrice = Double.POSITIVE_INFINITY;
        WebElementFacade cheapestButton = null;

        for (int i = 0; i < priceCells.size(); i++) {
            double currentPrice = parsePrice(priceCells.get(i).getText());

            if (currentPrice < cheapestPrice) {
                cheapestPrice = currentPrice;
                cheapestButton = buttons.get(i);
            }
        }

       cheapestButton.click();
        return cheapestPrice;
    }

    private double parsePrice(String priceText) {
        return Double.parseDouble(priceText.replace("$", "").replace(",", "").trim());
    }

}