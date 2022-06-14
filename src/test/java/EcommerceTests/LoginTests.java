package EcommerceTests;

import EcommercePages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {


    @Test(priority = 1, description = "test login scenarios with empty user name and password")
    public void validateLoginWithEmptyCredentials() {

        loginPage.clickLogin();
        Assert.assertTrue(loginPage.checkErrorMsgExists());
        String errorMsg = loginPage.getErrorMsgTest();
        Assert.assertEquals(errorMsg, dataparser.getPropertyValue("emptyCredentialserror"));
        loginPage.clickOnCloseErrorMsg();


    }

    @Test(priority = 2, description = "test login scenarios with empty user name and valid password")
    public void validteLoginWithEmptyUserName() {

        loginPage.typeUserPassword(dataparser.getPropertyValue("validpassword"));
        loginPage.clickLogin();
        String errorMsg = loginPage.getErrorMsgTest();
        Assert.assertEquals(errorMsg, dataparser.getPropertyValue("emptyUserNameError"));
        loginPage.clickOnCloseErrorMsg();


    }

    @Test(priority = 3, description = "test login scenarios with valie user name and empty password")
    public void validteLoginWithEmptyUserPassword() {
        loginPage.typeUserName(dataparser.getPropertyValue("validusername"));
        loginPage.clickLogin();
        String errorMsg = loginPage.getErrorMsgTest();
        Assert.assertEquals(errorMsg, dataparser.getPropertyValue("emptyPasswordError"));
        loginPage.clickOnCloseErrorMsg();


    }

    @Test(priority = 4, description = "test login scenarios with invalid user name and password")
    public void validteLoginWithInvalidCredentials() {
        loginPage.typeUserName(dataparser.getPropertyValue("validusername"));
        loginPage.typeUserPassword("invalid");
        loginPage.clickLogin();
        String errorMsg = loginPage.getErrorMsgTest();
        Assert.assertEquals(errorMsg, dataparser.getPropertyValue("invalidCredentialsError"));
        loginPage.clickOnCloseErrorMsg();

    }

    @Test(priority = 5, description = "test login scenarios with valid user name and password happy scenario")
    public void validateLoginValidCredentials() {
        ProductsPage homePage = loginPage.loginValidCredentials();
        Assert.assertTrue(homePage.checkProductsLogoExist());

    }


}

