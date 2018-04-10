package javaexe;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatepicjerJS {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\EclipseOxygenWorkspace\\\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.spicejet.com/");
		  driver.manage().window().maximize();
		  
		  String date="Sun, Apr 08 2018";
		  
		  //WebElement date1=driver.findElement(By.xpath("//input[@id='hp-widget__depart']"));
		  //input[@id='ctl00_mainContent_txt_Fromdate']//following-sibling::button[@class='ui-datepicker-trigger']
		  //ctl00_mainContent_view_date1
		  //WebElement date1=driver.findElement(By.xpath("//span[@id='view_fulldate_id_1']"));
		  String id="view_fulldate_id_1";
		  selectCalenderDateJS(driver, id, date);  

	}

	public static void selectCalenderDateJS(WebDriver driver, String id, String date) {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("document.getElementById('"+id+"').textContent='"+date+"';");
		  
		 }
}
