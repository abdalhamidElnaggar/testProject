package MapsApisTests;

import CommonUtils.TestDataParser;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class ApisBaseTest {
    TestDataParser dataparser;

    @BeforeClass
    public void setup()
    {
        dataparser = new TestDataParser();


        try {
            dataparser.readFile("src/main/resources/APIsData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
