package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static core.windowshandler.switchBrowserToTab;
@Log4j2
public class productdetailpageobject {
  //  private static final Logger log = LogManager.getLogger(productdetailpageobject.class);
//    private static final Logger logger = LogManager.getLogger(productdetailpageobject.class);
    WebDriver driver;


    private final By txt_searchbox= By.id("twotabsearchtextbox");
    private final By btn_searchbox= By.id("nav-search-submit-button");
 //   private final By selectproduct = By.xpath("//img[@alt='New Apple iPhone 12 Pro Max (256GB) - Graphite']");
    String pagetitleasuslaptop="Buy ASUS Celeron Dual Core - (4 GB/1 TB HDD/Windows 10 Home) X515MA-BR004T Thin and Light Laptop (15.6 inch, Transparent Silver, 1.80 Kg Online at Low Prices in India - Amazon.in";
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
               if(laptop.getText().contains("ASUS Celeron Dual Core")){
                   laptop.click();
               }
           }

     //   driver.findElement(selectproduct).click();
       }
       public void displayproductdetails() {
          // switchBrowserToTab();
           Assert.assertEquals(pagetitleasuslaptop, driver.getTitle());
           log.info("user is on product details page");
       }





}
