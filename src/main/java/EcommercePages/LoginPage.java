package EcommercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {


    private final WebDriver driver;
    private final By userName = By.id("user-name");
    private final By userPassword = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.xpath("//h3[@data-test='error']");
    private final By closeErrorMsg = By.xpath("//button[@class='error-button']");
    String validUserName = "standard_user";
    String validPswd = "secret_sauce";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUserName(String userNametxt) {
        driver.findElement(userName).sendKeys(userNametxt);

    }

    public void typeUserPassword(String UserPswd) {
        driver.findElement(userPassword).sendKeys(UserPswd);

    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public Boolean checkErrorMsgExists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return !driver.findElements(errorMsg).isEmpty();
    }

    public void clickOnCloseErrorMsg() {
        driver.findElement(closeErrorMsg).click();
        driver.findElement(userPassword).clear();
        driver.findElement(userName).clear();

    }

    public String getErrorMsgTest() {
        return driver.findElement(errorMsg).getText();
    }

    public ProductsPage loginValidCredentials() {
        typeUserName(validUserName);
        typeUserPassword(validPswd);
        clickLogin();
        return new ProductsPage(driver);
    }

}
