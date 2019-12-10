package myTrip.CucumberAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By date = By.xpath("//div[contains(@class,'sc-hmXxxW cuJnt')]");

	public WebElement SelectCategory() {
		return driver.findElement(category);
	}

	public WebElement Whereto() {
		return driver.findElement(whereto);
	}

	public WebElement City() {
		int count = driver.findElements(city).size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String selectCity = driver.findElements(city).get(i).getText();
			System.out.println(selectCity);
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

	public WebElement MonthYear() {
		int total = driver.findElements(year).size();
		System.out.println("Size: " + total);
		for (int i = 0; i < total; i++) {
			String Month = driver.findElements(year).get(i).getText();
			System.out.println(Month);
			//driver.findElement(nextMonth).click();
			if (Month.contains("March")) {
				driver.findElement(nextMonth).click();
				System.out.println("Hurray");
			}
			else {
				System.out.println("Inside while: "+Month);
			}
		}
		int count = driver.findElements(date).size();
		for (int j = 0; j < count; j++) {
			String checkin = driver.findElements(date).get(j).getText();
			if (checkin.equalsIgnoreCase("25")) {
				d = driver.findElement(date);
			}

		}
		return d;
	}

	public WebElement NextMonth() {
		return driver.findElement(nextMonth);
	}

}
