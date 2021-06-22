package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static core.windowshandler.switchBrowserToTab;
@Log4j2
public class productdetailpageobject {
    private static final Logger log = LogManager.getLogger(productdetailpageobject.class);
    private static final Logger logger = LogManager.getLogger(productdetailpageobject.class);
    WebDriver driver;


    private final By txt_searchbox= By.id("twotabsearchtextbox");
    private final By btn_searchbox= By.id("nav-search-submit-button");
    private final By selectproduct = By.xpath("//img[@alt='New Apple iPhone 12 Pro Max (256GB) - Graphite']");
    public productdetailpageobject(WebDriver driver){
        this.driver = driver;
    }


       public void productdetailspageurl() {
           driver.get("https://www.amazon.in/");
       }

       public void ProductSelectSearchResults() {
           driver.findElement(txt_searchbox).sendKeys("New Apple iPhone 12 Pro Max");
           driver.findElement(btn_searchbox).click();
       }
       public void selectproductfromlist() {
           driver.findElement(selectproduct).click();
       }
       public void displayproductdetails() {
          // switchBrowserToTab();
           Assert.assertEquals("Amazon.in : New Apple iPhone 12 Pro Max", driver.getTitle());
           log.info("user is on product details page");
       }



}
