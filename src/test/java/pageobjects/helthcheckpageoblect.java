package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
@Log4j2
public class helthcheckpageoblect {
  //  private static final Logger log = LogManager.getLogger(productdetailpageobject.class);
  // private static final Logger logger = LogManager.getLogger(productdetailpageobject.class);
    WebDriver driver;

    public helthcheckpageoblect(WebDriver driver){
        this.driver = driver;
    }
    public void assertamazonhomepage(){
        Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        log.info("user is on amazon home page");
    }


}
