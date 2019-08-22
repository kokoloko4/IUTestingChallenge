package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class RunnerHelper {

    public static WebDriver driver;

    @Before
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
        driver.get(readPropertiesFile.getBaseUrl());
    }

    @After
    public void exit(){
        driver.quit();
    }

}
