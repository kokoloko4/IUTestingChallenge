package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

    private String fileName;
    private InputStream input;
    private Properties properties;
    private static String BASE_PATH = "src/test/resources/";

    public ReadPropertiesFile(String fileName) {
        this.fileName = fileName;
    }

    public  void openFile(){
        try {
            input = new FileInputStream(BASE_PATH + this.fileName +".properties");
            properties= new Properties();
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeFile(){
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String property){
        return  properties.getProperty(property);
    }

}
