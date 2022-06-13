package EcommercePages;

import CommonUtils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage extends BasePage {
    private final By allItems = By.xpath("//div[@class='inventory_item_name']");
    private final By checkoutBtn = By.id("checkout");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By orderSuccessMsg = By.xpath("//div[@class='complete-text']");

    public CardPage(WebDriver driver) {
        super(driver);
    }

    public int getAlltemsAtCardPage() {
        return findElementsSize(allItems);
    }

    public void clickOnCheckout() {
        click(checkoutBtn);
    }

    public String getSuccessMsg() {
        return getElementText(orderSuccessMsg);
    }

    public void clickOnFinish() {
        click(finishBtn);
    }

    public void clickOnContinue() {
        click(continueBtn);
    }

    public void typeFirstName(String firstName) {
        type(firstNameInput, firstName);
    }

    public void typeLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void typePostalCode(String postalCode) {
        type(postalCodeInput, postalCode);

    }
}
