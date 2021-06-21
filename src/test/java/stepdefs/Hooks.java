package stepdefs;

import core.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
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
        windowshandler.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario scn) {
        if (scn.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

}
