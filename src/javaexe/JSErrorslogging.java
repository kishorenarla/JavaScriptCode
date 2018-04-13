package javaexe;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSErrorslogging {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		LoggingPreferences logprefer = new LoggingPreferences();
		logprefer.enable(LogType.BROWSER, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logprefer);
		System.setProperty("webdriver.chrome.driver", "C:\\EclipseOxygenWorkspace\\chromedriver.exe");
		driver = new ChromeDriver(cap);
	}
	
	public void extraxtJSLogsinfo()  //call this method in all @Tests to get Javascript errors in page
	{
		LogEntries logentries = driver.manage().logs().get(LogType.BROWSER);
	    for(LogEntry entry :logentries)
	    {
	    	System.out.println(new Date(entry.getTimestamp()+""+entry.getLevel()+""+entry.getMessage()));
	    }
	}
	
	//=========example===========//
	@Test
	public void testMethod()
	{
		driver.get("http://www.google.com");
		extraxtJSLogsinfo();
	}
	
	@Test
	public void Contactpage()
	{
		driver.get("http://www.google.com");
		extraxtJSLogsinfo();
	}
	

}
