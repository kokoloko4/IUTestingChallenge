package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class RunnerHelper {

    public static WebDriver driver;

    @Before
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void exit(){
        driver.quit();
    }

}
