package action_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimeSheet {
WebDriver driver;

	public TimeSheet(WebDriver driver) {
		this.driver=driver;
	}
	 private WebElement getLogoutButton() throws InterruptedException{
		 driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/a/span")).click();	
		 System.out.println("has clicked");
		 Thread.sleep(500);
	WebElement logout = driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/ul/li[5]/a"));
		//logout.click();
	//System.out.println("dropmenu is "+logout.isDisplayed());
			return logout;
			
	    }
	    
	public  Boolean havingLogoutButton() throws InterruptedException{
		driver.switchTo().alert().accept();
		System.out.println("alert box handled");
		if(getLogoutButton().isDisplayed())
		{
			getLogoutButton().click();
			return true;
		}
		return false;
    }
}
