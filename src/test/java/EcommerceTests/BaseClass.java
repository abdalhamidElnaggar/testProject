package EcommerceTests;

import CommonUtils.TestDataParser;
import EcommercePages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseClass {

    WebDriver driver;
    TestDataParser dataparser;
    LoginPage loginPage;

    @BeforeTest
    public void setup() {
        //driver initlializations
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void init() {
        dataparser = new TestDataParser();


        try {
            dataparser.readFile("src/main/resources/testdata.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = dataparser.getPropertyValue("url");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //open browser
        driver.get(url);
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void close() {

        driver.quit();
    }


}


