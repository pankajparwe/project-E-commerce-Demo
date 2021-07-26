package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import core.windowshandler;

import java.util.List;
import java.util.concurrent.TimeUnit;




@Log4j2
public class productdetailpageobject {
  //  private static final Logger log = LogManager.getLogger(productdetailpageobject.class);
//    private static final Logger logger = LogManager.getLogger(productdetailpageobject.class);
    WebDriver driver;


    private final By txt_searchbox= By.id("twotabsearchtextbox");
    private final By btn_searchbox= By.id("nav-search-submit-button");
 //   private final By selectproduct = By.xpath("//img[@alt='New Apple iPhone 12 Pro Max (256GB) - Graphite']");
    String pagetitleasuslaptop="Amazon.in: Buy HP 15 Thin & Light 15.6\"(39.62cms) FHD Laptop (11th Gen Intel Core i5-1135G7, 8GB DDR4, 1TB HDD, Windows 10 Home, MS Office, Integrated Graphics, FPR, Natural Silver, 1.76 Kg), 15s-du3032TU Online at Low Prices in India | HP Reviews & Ratings";
    public productdetailpageobject(WebDriver driver){
        this.driver = driver;
    }


       public void productdetailspageurl() {
           driver.get("https://www.amazon.in/");
       }

       public void ProductSelectSearchResults() {
           driver.findElement(txt_searchbox).sendKeys("laptop");
           driver.findElement(btn_searchbox).click();
       }
       public void selectproductfromlist() {
           List<WebElement> laptops=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
          // System.out.println(laptops.size());
           //ASUS Celeron Dual Core
           for(WebElement laptop : laptops)
           {
               if(laptop.getText().contains("HP 15 Thin & Light 15.6")){
                   laptop.click();
               }
           }

     //   driver.findElement(selectproduct).click();
       }
       public void displayproductdetails() {
        windowshandler windowshandler =new windowshandler();
        windowshandler.switchBrowserToTab();



           Assert.assertEquals(pagetitleasuslaptop, driver.getTitle());
           log.info("user is on product details page");
       }





}
