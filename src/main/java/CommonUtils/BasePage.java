package CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }


    protected int findElementsSize(By locator) {
        return driver.findElements(locator).size();
    }


    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        find(locator).click();
    }

    protected void clear(By locator) {
        find(locator).clear();
    }



    protected String getElementText(By locator) {
        return find(locator).getText();
    }

    protected boolean checkElementExists(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return !driver.findElements(locator).isEmpty();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    protected void selecDropDownMenu(By locator , String filterCriteria) {


        Select drpProducts = new Select(find(locator));
        drpProducts.selectByValue(filterCriteria);

    }
}
