package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElementFacade confirmationMessage;

    public String getConfirmationMessage() {
        return confirmationMessage.waitUntilVisible().getText().trim();
    }

    public String getConfirmationId() {
        return findBy("//td[text()='Id']/following-sibling::td")
                .waitUntilVisible()
                .getText()
                .trim();
    }
}
