package EcommercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage {
    private final By allItems = By.xpath("//div[@class='inventory_item_name']");
    private final By checkoutBtn = By.id("checkout");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By orderSuccessMsg = By.xpath("//div[@class='complete-text']");
    private WebDriver driver;

    public CardPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getAlltemsAtCardPage() {
        return driver.findElements(allItems).size();
    }

    public void clickOnCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public String getSuccessMsg() {
        return driver.findElement(orderSuccessMsg).getText();
    }

    public void clickOnFinish() {
        driver.findElement(finishBtn).click();
    }

    public void clickOnContinue() {
        driver.findElement(continueBtn).click();
    }

    public void typeFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void typePostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }
}
