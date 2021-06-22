package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

@Log4j2
public class cartdetailspageobject {
    private static final Logger log = LogManager.getLogger(cartdetailspageobject.class);
    private static final Logger logger = LogManager.getLogger(cartdetailspageobject.class);
     WebDriver driver;

private  By productquantity= By.xpath("//select[@id='quantity']");
private  By btn_addtocart = By.id("add-to-cart-button");
private  By cartpage =By.xpath("//span[@class='nav-cart-icon nav-sprite']");

    public cartdetailspageobject(WebDriver driver){

        this.driver = driver;
    }

    public void selectQuantity(){
        Select select = new Select(driver.findElement(productquantity));
        select.selectByValue("2");
        log.info("Quantity is selected as :2");


    }
    public void clickonaddtocart() throws InterruptedException {
     driver.findElement(btn_addtocart).click();
    // driver.findElement(cartpage).click();

     Thread.sleep(2000);
    }
    public void cartpagedetails(){
      driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']")).isDisplayed();
     //   driver.getPageSource().contains("");
        log.info("product is added to the cart");
    }
}
