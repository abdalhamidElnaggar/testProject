package MapsApisTests;

import CommonUtils.TestDataParser;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApisBaseTest {
    TestDataParser dataparser;

    @BeforeClass
    public void setup() {
        dataparser = new TestDataParser();


        try {
            dataparser.readFile("src/main/resources/APIsData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> createValidheaders() {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Auth-Service-Id", "here_app");
        requestHeaders.put("Auth-Identifier", "apikey");
        requestHeaders.put("Auth-Secret", dataparser.getPropertyValue("ApiValidkey"));
        requestHeaders.put("Content-Type", "application/vnd.here.layerObjectList+json; charset=UTF-8");
        requestHeaders.put("Content-Disposition", "application/vnd.here.layerObjectList+json; charset=UTF-8");
        requestHeaders.put("Content-Type", " application/vnd.here.layerObjectList+json; charset=UTF-8");
        return requestHeaders;
    }

    public String createValidPayload() {
        String validPayLoad = "[{\n" +
                "  \"type\":\"Point\",\n" +
                "  \"coordinates\":[8.55,50.148,0],\n" +
                "  \"properties\": {\n" +
                "  \"v\": \"2.7\",\n" +
                "    \"appId\": \"\",\n" +
                "    \"error\": 920,\n" +
                "    \"domain\":{\n" +
                "      \"signValue\": \"100\",\n" +
                "      \"signUnit\": \"km/h\",\n" +
                "      \"subType\": 3\n" +
                "    },\n" +
                "    \"details\": \"The speed limit is now 100 km/h\",\n" +
                "    \"currentValues\": {\n" +
                "      \"signValue\": \"80\"\n" +
                "  },\n" +
                "    \"zoomLevel\": 15,\n" +
                "    \"mapType\": \"hybrid.live\",\n" +
                "    \"accountId\": \"\"\n" +
                "  }\n" +
                "}]";
        return validPayLoad;
    }

    public String createInValidPayload() {
        String validPayLoad = "[{\n" +
                "  \"type\":\"\",\n" +
                "  \"coordinates\":[8.55,50.148,0],\n" +
                "  \"properties\": {\n" +
                "  \"v\": \"2.7\",\n" +
                "    \"appId\": \"\",\n" +
                "    \"error\": 920,\n" +
                "    \"domain\":{\n" +
                "      \"signValue\": \"100\",\n" +
                "      \"signUnit\": \"km/h\",\n" +
                "      \"subType\": 3\n" +
                "    },\n" +
                "    \"details\": \"The speed limit is now 100 km/h\",\n" +
                "    \"currentValues\": {\n" +
                "      \"signValue\": \"80\"\n" +
                "  },\n" +
                "    \"zoomLevel\": 15,\n" +
                "    \"mapType\": \"hybrid.live\",\n" +
                "    \"accountId\": \"\"\n" +
                "  }\n" +
                "}]";
        return validPayLoad;
    }


}
