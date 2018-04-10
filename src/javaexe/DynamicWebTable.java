package javaexe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicWebTable {
	
	public void WebtableVerification()
	{
	WebDriver driver = null;
	
	//divide xpath in to two because here row number changes everytime
	String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
	String after_xpath = "]/td[2]/a";
	
	for(int i=4; i<=7; i++){ // row data starts from row 4
		
		String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		System.out.println(name);
		if(name.contains("test2 test2")){ //i=6
			//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
			driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();// clicks on check box
		}
	}
	
	//Method-2:
	driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'ui uiii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();

	}
}
