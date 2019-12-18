package myTrip;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageobjectHotelSearch {
	
	WebDriver driver;
	public PageobjectHotelSearch(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By headbar=By.id("global-header-nav-section");
	By Choose=By.xpath("//*[@id='main-wrapper']/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/a/div");
	
	public void newtab()
	{
	    Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentid=it.next();
        String childid=it.next();
        driver.switchTo().window(childid); 
		
	/*	Set<String> tab_handles = driver.getWindowHandles();
	    int number_of_tabs = tab_handles.size();
	    int new_tab_index = number_of_tabs-1;
	    driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString()); */
	}
	
	public WebElement validate()
	{
		return driver.findElement(headbar);
	}
	
	public WebElement ChooseHotel()
	{
		return driver.findElement(Choose);
	}

}
