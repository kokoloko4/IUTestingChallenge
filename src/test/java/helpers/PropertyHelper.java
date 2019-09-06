package helpers;

import utils.ReadPropertiesFile;

public class PropertyHelper {

    public static String getUrl(String url){
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile("config");
        readPropertiesFile.openFile();
        String urlProductPage = readPropertiesFile.getProperty(url);
        readPropertiesFile.closeFile();
        return urlProductPage;
    }
}
