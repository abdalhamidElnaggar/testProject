package EcommerceTests;

import EcommercePages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingProductsTests extends BaseClass {


    @Test(priority = 1, description = "add items to the card and check if the it is added to the shopping card")
    public void addProductTest() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        int itemCount = 6;
        productPage.addItemtoCard(itemCount);
        Assert.assertEquals(productPage.getShoppingCartItemsCount(), String.valueOf(itemCount));


    }

    @Test(priority = 2, description = "add items to the card and check if the it is added " +
            "to the shopping card then remove them and check if card is empty")
    public void addThenRemoveProductTest() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        int itemCount = 3;
        productPage.addItemtoCard(itemCount);
        Assert.assertEquals(productPage.getShoppingCartItemsCount(), String.valueOf(itemCount));
        productPage.removeItemFromCard(itemCount);
        Assert.assertTrue(productPage.isCardEmpty());


    }
}
