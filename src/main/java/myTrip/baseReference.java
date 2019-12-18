package myTrip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class baseReference {

	public WebDriver driver;
	public Properties prop;
	String Browser;
	public String url;

	public WebDriver initialize() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nitin\\eclipse-workspace\\CucumberAutomation\\src\\main\\java\\myTrip\\Data.properties");
		prop.load(fis);
		Browser = prop.getProperty("browser");
		System.out.println(Browser);

		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nitin\\eclipse-workspace\\CucumberAutomation\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\nitin\\eclipse-workspace\\CucumberAutomation\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (Browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\nitin\\Desktop\\Selenium\\Drivers\\IEDriver\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}
