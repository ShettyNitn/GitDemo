package myTrip.CucumberAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageobjFlightHome {

	WebDriver driver;
	WebElement d;

	public PageobjFlightHome(WebDriver driver) {
		this.driver = driver;
	}

	By category = By.xpath("//div[text()='HOTELS']");
	By whereto = By.id("location");
	By city = By.xpath("//div[contains(@id,'location-dropdown-item')]");
	By Checkinout = By.id("date-range");
	By year = By.cssSelector("div[class*='Month__MonthName-sc-12ikvnx-0 fijJjj']");
	By nextMonth = By.cssSelector(".CalendarCard__RightArrow-sc-1jxm5yu-3 > svg:nth-child(1)");
	//By date = By.xpath("//*[@id='hotel-date-range']/div[2]/div/div/div/div[2]/div/div");
	By clickRoom= By.id("roomCount");
	By Search=By.xpath("//*[@id='hotels']/div/div/div/div[5]/button");

	public WebElement SelectCategory() {
		return driver.findElement(category);
	}

	public WebElement Whereto() {
		return driver.findElement(whereto);
	}

	public WebElement City() {
		int count = driver.findElements(city).size();
	//	System.out.println(count);
		for (int i = 0; i < count; i++) {
			String selectCity = driver.findElements(city).get(i).getText();
		//	System.out.println(selectCity);
			if (selectCity.equalsIgnoreCase("Chicago Heights, IL")) {
				d = driver.findElements(city).get(i);
				break;
			}

		}
		return d;
	}

	public WebElement CheckInOut() {
		return driver.findElement(Checkinout);

	}

	public void CheckinDate() {
		int total = driver.findElements(year).size();
		//System.out.println("Size: " + total);
		for (int i = 0; i < total; i++) {
			String Mon = "March";
		//	System.out.println(driver.findElements(year).get(i).getText());
			// driver.findElement(nextMonth).click();
			if (driver.findElements(year).get(i).getText().contains(Mon)) {
				int selmon = 4;
				int date = 25;
				driver.findElement(By.xpath(
						"//*[@id='hotel-date-range']/div[2]/div/div/div/div[2]/div/div/div["+selmon+"]/div[3]/div["+date+"]/div")).click();
				break;
			}
		
	else
		driver.findElement(nextMonth).click();
	}
	}
	
	public void CheckoutDate() {
		int total = driver.findElements(year).size();
	//	System.out.println("Size: " + total);
		for (int i = 0; i < total; i++) {
			String Mon = "April";
		//	System.out.println(driver.findElements(year).get(i).getText());
			// driver.findElement(nextMonth).click();
			if (driver.findElements(year).get(i).getText().contains(Mon)) {
				int selmon = 5;
				int date = 8;
				driver.findElement(By.xpath(
						"//*[@id='hotel-date-range']/div[2]/div/div/div/div[2]/div/div/div["+selmon+"]/div[3]/div["+date+"]/div")).click();
				break;
			}
		
	else
		driver.findElement(nextMonth).click();
	}
	}
	public void RoomCount() {
		int room=3;
		Select s=new Select(driver.findElement(clickRoom));
		s.selectByIndex(room);
	}
	
	public WebElement ClickSearch()
	{
		return driver.findElement(Search);
	}

}

/*
 * * int count = driver.findElements(date).size(); System.out.println(count);
 * for (int j = 0; j < count; j++) {
 * 
 * String checkin = driver.findElements(date).get(j).getText();
 * System.out.println(checkin); if (checkin.contains("25")) {
 * driver.findElement(date).click(); break;
 * 
 */
