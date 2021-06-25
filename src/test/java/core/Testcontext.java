package core;

import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

@Log4j2
public class Testcontext {
  //  private static final Logger log = LogManager.getLogger(Testcontext.class);
    private static final Logger logger = LogManager.getLogger(Testcontext.class);
    public WebDriver driver;
    public Scenario scn;
    public cartdetailspageobject cartdetailspageobject;
    public productdetailpageobject productdetailpageobject;
    public helthcheckpageoblect helthcheckpageoblect;

    public Testcontext() {
    }

    public void InitialiesWebDiver(){
        this.driver = new ChromeDriver();
         log.info("Browser invoked");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        logger.info("Driver maximized and implicit time out set to 20 seconds");
    }


    public void intializePageObjects(){
        cartdetailspageobject =new cartdetailspageobject(driver);
        productdetailpageobject= new productdetailpageobject(driver);
        helthcheckpageoblect =new helthcheckpageoblect(driver);
    }
}
