package base_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import action_classes.loginAction;

public class driver {
	public static WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.out.println("before class is running");
		String exePath = "C:\\Users\\Vardasaxena\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	    driver = new ChromeDriver();
	     driver.get("https://s-hris.qainfotech.com");
	    	

}
}
