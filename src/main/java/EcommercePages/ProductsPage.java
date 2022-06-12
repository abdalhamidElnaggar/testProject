package EcommercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final By productsLogo = By.xpath("//span[text()='Products']");
    private final By filtersDropDown = By.xpath("//select[@class='product_sort_container']");
    private final By firstItem = By.xpath("(//div[@class='inventory_item_name'])[1]");
    private final By secondItem = By.xpath("(//div[@class='inventory_item_name'])[2]");
    private final By firstItemPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
    private final By secondItemPrice = By.xpath("(//div[@class='inventory_item_price'])[2]");
    private final By firstItemAddToCartBtn = By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]");
    private final By firstItemRemovebBtn = By.xpath("(//button[@class='btn btn_secondary btn_small btn_inventory'])[1]");

    private final By shoppingCart = By.xpath("//span[@class='shopping_cart_badge']");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkProductsLogoExist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsLogo));
        return !driver.findElements(productsLogo).isEmpty();
    }

    public void filterProducts(String filterCriteria) {
        Select drpProducts = new Select(driver.findElement(filtersDropDown));
        drpProducts.selectByValue(filterCriteria);

    }

    public String getShoppingCartItemsCount() {
        return driver.findElement(shoppingCart).getText();

    }

    public CardPage clickOnShoppingCard() {
        driver.findElement(shoppingCart).click();
        return new CardPage(driver);
    }

    public boolean isCardEmpty() {
        return driver.findElements(shoppingCart).isEmpty();

    }

    public String compareStringSorting() {
        String firstItemtxt = driver.findElement(firstItem).getText();
        String secondItemtxt = driver.findElement(secondItem).getText();
        String sortingOrder = null;
        int compare = firstItemtxt.compareTo(secondItemtxt);

        if (compare < 0) {
            sortingOrder = "ASC";
        } else if (compare > 0) {
            sortingOrder = "DESC";

        }
        return sortingOrder;

    }

    public String comparePrices() {
        String itemPrice1 = driver.findElement(firstItemPrice).getText();
        String itemPrice2 = driver.findElement(secondItemPrice).getText();

        StringBuilder sb1 = new StringBuilder(itemPrice1);
        StringBuilder sb2 = new StringBuilder(itemPrice2);
        float price1 = Float.parseFloat(sb1.deleteCharAt(0).toString());
        float price2 = Float.parseFloat(sb2.deleteCharAt(0).toString());
        if (price1 > price2) {
            return "DESC";
        } else {
            return "ASC";
        }


    }

    public void addItemtoCard(int itemCount) {
        for (int i = 1; i <= itemCount; i++) {
            int itemNum = i;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(firstItemAddToCartBtn));
            driver.findElement(firstItemAddToCartBtn).click();
        }
    }

    public void removeItemFromCard(int itemCount) {
        for (int i = 1; i <= itemCount; i++) {
            int itemNum = i;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(firstItemRemovebBtn));
            driver.findElement(firstItemRemovebBtn).click();
        }
    }


}