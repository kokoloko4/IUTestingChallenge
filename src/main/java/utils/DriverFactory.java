package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    /**
     * @return The driver that will be used in the test
     */
    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Remove the driver created
     */
    public static void deleteDriver(){
        driver.quit();
        driver = null;
    }
}
