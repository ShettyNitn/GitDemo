package stepDefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myTrip.PageobjFlightHome;
import myTrip.PageobjectHotelSearch;
import myTrip.baseReference;


public class stepDef extends baseReference {
	
	public static Logger log = LogManager.getLogger(stepDef.class.getName());

	@Given("^User is on priceline homepage$")
	public void user_is_on_priceline_homepage() throws IOException {
		log.debug("Initialize Driver");
		driver=initialize();
		log.info("Driver Initialized");
		log.debug("Launch Url");
		driver.get(prop.getProperty("Url"));
		log.info("Pricline website launched and opened");
		driver.manage().window().maximize();
		log.info("Screen Maximized");
	}

	@When("^Enter hotel information$")
	public void enter_hotel_information() throws Throwable {
		PageobjFlightHome ph = new PageobjFlightHome(driver);
		log.debug("Click on Whereto checkbox on Hotel homepage");
		ph.Whereto().click();
		log.debug("Send keys Chi in the searchbox");
		ph.Whereto().sendKeys("Chi");
		log.info("Character Chi entered in the Searchbox");
		ph.City().click();
		log.info("City Selected");
		ph.CheckInOut().click();
		log.debug("Select Checkin Date");
		ph.CheckinDate();
		log.info("Checking Date Selected");
		log.debug("Select Checkout Date");
		ph.CheckoutDate();
		log.info("Checkout Date Selected");
		log.debug("Select no of rooms required");
		ph.RoomCount();
		log.info("Room count selected");
		

	}

	@Then("^Search the relevant information$")
	public void search_the_relevant_information() throws Throwable {
		PageobjFlightHome ph = new PageobjFlightHome(driver);
		System.out.println("Before Click");
		ph.ClickSearch().click();
		System.out.println("Yeah Click");
	}

	@And("^Validate Results are displayed$")
    public void validate_results_are_displayed() throws Throwable {
		System.out.println("After Click");
        PageobjectHotelSearch phs=new PageobjectHotelSearch(driver);
        phs.newtab();
        Assert.assertTrue(phs.validate().isDisplayed());
        System.out.println(phs.validate().getText());
        System.out.println("Done!!!");
        
        driver.getTitle();
        
        phs.ChooseHotel().click();
        
    }
}
