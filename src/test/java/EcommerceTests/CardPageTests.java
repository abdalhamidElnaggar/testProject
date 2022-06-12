package EcommerceTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardPageTests extends BaseClass {


    @Test(priority = 1, description = "add items to the card and check them at the card page")
    public void addProductsandCheckoutTest() {

        var productPage = loginPage.loginValidCredentials();
        int itemCount = 3;
        productPage.addItemtoCard(itemCount);
        var cardPage = productPage.clickOnShoppingCard();
        Assert.assertEquals(cardPage.getAlltemsAtCardPage(), itemCount);


    }

    @Test(priority = 2, description = "add items to the card and continue the checkout process E2E")
    public void checkoutE2EScenario() {

        var productPage = loginPage.loginValidCredentials();
        int itemCount = 3;
        productPage.addItemtoCard(itemCount);
        var cardPage = productPage.clickOnShoppingCard();
        cardPage.clickOnCheckout();
        cardPage.typeFirstName(dataparser.getPropertyValue("firstname"));
        cardPage.typeLastName(dataparser.getPropertyValue("lastname"));
        cardPage.typePostalCode(dataparser.getPropertyValue("postalcode"));
        cardPage.clickOnContinue();
        cardPage.clickOnFinish();
        Assert.assertEquals(cardPage.getSuccessMsg(), dataparser.getPropertyValue("successmsg"));


    }
}
