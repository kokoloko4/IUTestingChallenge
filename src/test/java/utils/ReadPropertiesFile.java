package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

    private static String baseUrl;
    private static String productUrl;
    private static String shoppingBagUrl;

    public ReadPropertiesFile() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/config.properties");
        Properties prop = new Properties();
        prop.load(input);
        baseUrl = prop.getProperty("baseUrl");
        productUrl = prop.getProperty("productUrl");
        shoppingBagUrl = prop.getProperty("shoppingBagUrl");
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String getProductUrl(){return  productUrl;}

    public String getShoppingBag(){return shoppingBagUrl;}
}
