package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataParser {
    private FileInputStream stream;
    private String RepositoryFile;
    private Properties propertyFile = new Properties();


    public void readFile(String fileName) throws IOException {
        this.RepositoryFile = fileName;
        stream = new FileInputStream(RepositoryFile);
        propertyFile.load(stream);
    }

    public String getPropertyValue(String valueName) {
        return propertyFile.getProperty(valueName);

    }
}
