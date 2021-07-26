package core;

import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

@Log4j2
public class windowshandler {

    Testcontext testcontext;
    WebDriver driver;

    //Dependency Injections using Pico Container
    public windowshandler(Testcontext testcontext) {
        this.testcontext = testcontext;
        driver = testcontext.driver;

    }

    public windowshandler() {

    }


    public void switchBrowserToTab() {
            WebDriverWait wait = new WebDriverWait(testcontext.driver, 20);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            //As product description click will open new tab, we need to switch the driver to the new tab
            //If you do not switch, you can not access the new tab html elements
            //This is how you do it
            Set<String> handles = testcontext.driver.getWindowHandles(); // get all the open windows
            log.info("List of windows found: " + handles.size());
            log.info("Windows handles: " + handles.toString());
            Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
            String original = it.next();//gives the parent window id
            String nextTab = it.next();//gives the child window id
            driver.switchTo().window(nextTab); // switch to product Descp
            log.info("Switched to the new window/tab");
        }

        public void switchToOriginalTab () {
            Set<String> handles = driver.getWindowHandles();
            log.info("List of windows found: " + handles.size());
            log.info("Windows handles: " + handles.toString());
            Iterator<String> it = handles.iterator();
            String original = (String) it.next();
            driver.switchTo().window(original);
            log.info("Switched to the original window/tab");
        }


    }
