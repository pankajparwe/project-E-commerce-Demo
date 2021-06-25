package stepdefs;

import core.Testcontext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobjects.cartdetailspageobject;
import pageobjects.productdetailpageobject;
@Log4j2
public class stepdefs {

    Testcontext testcontext;
    public Scenario scn;


    //Dependency Injections using Pico Container
    public stepdefs(Testcontext testcontext) {
        this.testcontext = testcontext;
        this.scn =testcontext.scn;

    }
    @Given("User searched for the product")
    public void user_searched_for_the_product() {
        testcontext.driver.get("https://www.amazon.in/");
        testcontext.productdetailpageobject.ProductSelectSearchResults();
    }

    @When("User click on any product")
    public void user_click_on_any_product() {

        testcontext.productdetailpageobject.selectproductfromlist();
    }


    @Then("User is navigated to the new tab and product details are displayed")
    public void user_is_navigated_to_the_new_tab_and_product_details_are_displayed() {
        testcontext.productdetailpageobject.displayproductdetails();
    }


    @Given("User is on the product details page")
    public void user_is_on_the_product_details_page() {
       testcontext.driver.get("https://www.amazon.in/Fire-Boltt-Bluetooth-Headphones-Lightweight-Assistance/dp/B0814GJNKG/ref=sr_1_1_sspa?dchild=1&keywords=headphones&qid=1624290282&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyUFlXTUNaRjRQUVk5JmVuY3J5cHRlZElkPUEwOTkzMDc2MzM0WTNDOTRDUkNTOSZlbmNyeXB0ZWRBZElkPUEwMzc0MzEwMVpLM1c0MzRKNDlRUCZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=");
    }



    @When("User selects the product quantity as 2")
    public void user_selects_the_product_quantity_as_2() {
        testcontext.cartdetailspageobject.selectQuantity();


    }
    @And("User clicks add to cart on the page on product details page")
    public void user_clicks_add_to_cart_on_the_page_on_product_details_page() throws InterruptedException {
    testcontext.cartdetailspageobject.clickonaddtocart();
    }


    @Then("Product is added to the cart")
    public void product_is_added_to_the_cart() {
        testcontext.cartdetailspageobject.cartpagedetails();

    }

    @Given("User Opened the Browser")
    public void user_opened_the_browser() {

    }




    @When("User navigated to the app url")
    public void user_navigated_to_the_app_url() {
        testcontext.driver.get("https://www.amazon.in/");

    }
    @Then("User is able to see application landing page")
    public void user_is_able_to_see_application_landing_page() {
        testcontext.helthcheckpageoblect.assertamazonhomepage();


    }


}


