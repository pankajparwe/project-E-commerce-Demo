package stepdefs;

import core.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.cartdetailspageobject;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static final Logger log = LogManager.getLogger(cartdetailspageobject.class);
    private static final Logger logger = LogManager.getLogger(cartdetailspageobject.class);
    Testcontext testcontext;
    WebDriver driver;

    //Dependency Injections using Pico Container
    public Hooks(Testcontext testcontext) {
        this.testcontext = testcontext;
        driver = testcontext.driver;

    }

    @Before
    public void setUp(Scenario scn) throws Exception {
        testcontext.InitialiesWebDiver();
        testcontext.intializePageObjects();
        testcontext.scn = scn;
    }

    @After(order = 1)
    public void cleanUp(Scenario scn){
        testcontext.driver.quit();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario scn) {
        if (scn.isFailed()) {
            TakesScreenshot scrnShot = ((TakesScreenshot) testcontext.driver);
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

}
