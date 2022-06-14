package EcommercePages;

import CommonUtils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By userName = By.id("user-name");
    private final By userPassword = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.xpath("//h3[@data-test='error']");
    private final By closeErrorMsg = By.xpath("//button[@class='error-button']");
    String validUserName = "standard_user";
    String validPswd = "secret_sauce";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String userNametxt) {
        type(userName, userNametxt);

    }

    public void typeUserPassword(String userPswd) {
        type(userPassword, userPswd);


    }

    public void clickLogin() {
        click(loginBtn);
    }

    public Boolean checkErrorMsgExists() {
        return checkElementExists(errorMsg);
    }

    public void clickOnCloseErrorMsg() {
        click(closeErrorMsg);
        clear(userPassword);
        clear(userName);
    }

    public String getErrorMsgTest() {
        return getElementText(errorMsg);
    }

    public ProductsPage loginValidCredentials() {
        type(userName, validUserName);
        type(userPassword, validPswd);
        click(loginBtn);
        return new ProductsPage(driver);
    }

}
