package test_classes;
import action_classes.TimeSheet;
import action_classes.loginAction;
import base_class.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utility.excelData;

public class loginTest extends driver {

	loginAction loginAction;
	   TimeSheet timeSheet; 
        @Test(dataProvider="Authentication_with_invalid_data")
	    public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(String username,String password){
	   loginAction=new loginAction(driver);
	        Assert.assertTrue(loginAction
	                .loginWithIncorrectCredentials(username,password).contains("Invalid Login"));
	        System.out.println("test with incorrect password has passed");
	    }
	    
	    @Test(dataProvider="Authentication_with_no_password")
	    public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field(String username,String password){
	    	loginAction=new loginAction(driver);
	    	  loginAction.login(username,password);
	        // red border in password entry
	        Assert.assertTrue(loginAction.isPasswordEntryAnnotated());  
	        System.out.println("test with blank password has passed");
	    }
	    
	    @Test(dataProvider="Authentication_with_valid_data")
	    public void attempt_login_with_correct_credentials_should_go_to_timesheet_page(String username,String password) throws InterruptedException
	    {
	    	
	    	loginAction=new loginAction(driver);
	    	//System.out.println(loginAction.loginWithCorrectCredentials("raman", "qainfotech").toString());
	  	Assert.assertTrue(loginAction.loginWithCorrectCredentials(username, password).havingLogoutButton());
	  
	    }
	    
	   @DataProvider
	    public Object[][] Authentication_with_valid_data() throws Exception{
	 System.out.println("in the data provider");
	  Object[][] testObjArray=excelData.getTableArray( System.getProperty("user.dir")+"\\src\\loginData\\\\practice.xlsx","Sheet1");
	
	         return testObjArray;
	 
			}
	   @DataProvider
	   public Object[][] Authentication_with_invalid_data() throws Exception{
		   Object[][] testObjArray=excelData.getTableArray( System.getProperty("user.dir")+"\\src\\loginData\\\\practice.xlsx","Sheet2");
		   return testObjArray;
	   }
	 
	   @DataProvider
	   public Object[][] Authentication_with_no_password() throws Exception{
		   Object[][] testObjArray=excelData.getTableArray( System.getProperty("user.dir")+"\\src\\loginData\\\\practice.xlsx","Sheet3");
		   return testObjArray;
	   }
	    
}
