package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunnerHelper {

    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.falabella.com.co");
    }

    @After
    public void exit(){
        driver.quit();
    }

}
