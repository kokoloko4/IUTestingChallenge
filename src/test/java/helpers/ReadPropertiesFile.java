package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

    private static String baseUrl;

    public ReadPropertiesFile() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/config.properties");
        Properties prop = new Properties();
        prop.load(input);
        baseUrl = prop.getProperty("baseUrl");
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}
