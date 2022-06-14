package EcommerceTests;

import EcommercePages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseClass {

    @Test(priority = 2, description = "test sorting products by name  alphabetical ASC order")
    public void filterProductsByNameASC() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        productPage.filterProducts(dataparser.getPropertyValue("sortProductsByNameASC"));
        String compareValue = productPage.compareStringSorting();
        Assert.assertEquals(compareValue, "ASC");


    }

    @Test(priority = 1, description = "test sorting products by name alphabetical DEC order")
    public void filterProductsByNameDESC() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        productPage.filterProducts(dataparser.getPropertyValue("sortProductsByNameDESC"));
        String compareValue = productPage.compareStringSorting();
        Assert.assertEquals(compareValue, "DESC");


    }

    @Test(priority = 3, description = "test sorting products by price alphabetical ASC order")
    public void filterProductsByPriceDESC() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        productPage.filterProducts(dataparser.getPropertyValue("sortProductsByPriceDesc"));
        String compareValue = productPage.comparePrices();
        Assert.assertEquals(compareValue, "DESC");

    }

    @Test(priority = 4, description = "test sorting products by price alphabetical DESC order")
    public void filterProductsByPriceASC() {

        ProductsPage productPage = loginPage.loginValidCredentials();
        productPage.filterProducts(dataparser.getPropertyValue("sortProductsByPriceASC"));
        String compareValue = productPage.comparePrices();
        Assert.assertEquals(compareValue, "ASC");

    }


}
