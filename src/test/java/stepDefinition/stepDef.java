package stepDefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myTrip.CucumberAutomation.PageobjFlightHome;
import myTrip.CucumberAutomation.PageobjectHotelSearch;
import myTrip.CucumberAutomation.baseReference;

public class stepDef extends baseReference {

	@Given("^User is on priceline homepage$")
	public void user_is_on_priceline_homepage() throws IOException {
		System.out.println("Initialize Driver");
		driver=initialize();
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
	}

	@When("^Enter hotel information$")
	public void enter_hotel_information() throws Throwable {
		PageobjFlightHome ph = new PageobjFlightHome(driver);
		//ph.SelectCategory().click();
		ph.Whereto().click();
		ph.Whereto().sendKeys("Chi");
		ph.City().click();
		ph.CheckInOut().click();
		ph.CheckinDate();
		ph.CheckoutDate();
		ph.RoomCount();
		

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
