package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;


import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void exit(){
        DriverFactory.deleteDriver();
    }
}
