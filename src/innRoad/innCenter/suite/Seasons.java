package innRoad.innCenter.suite;

import innRoad.innCenter.base.*;
import innRoad.innCenter.util.TestUtil;

import java.awt.List;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Seasons extends BaseTest {
	
	
	  @Test(dataProvider = "testParameterData")
	  public void testUntitled(String Client_id,String User_ID,String Password,String Season_Name,String Status,String Start_Date,String End_Date)
			  
			  throws Exception {
	
			d.get("http://demo.innroad.com/login.aspx");
		
//login into the Site
			
			//try {
		  d.findElement(By.xpath("//*[@id='txtclientCode']")).clear();
		  d.findElement(By.xpath("//*[@id='txtclientCode']")).sendKeys(Client_id);
		  Wait.wait2Second();
		  d.findElement(By.xpath("//*[@id='txtLoginID']")).clear();
		  d.findElement(By.xpath("//*[@id='txtLoginID']")).sendKeys(User_ID);
		  Wait.wait2Second();
		  d.findElement(By.xpath("//*[@id='txtUserPassword']")).clear();
		  d.findElement(By.xpath("//*[@id='txtUserPassword']")).sendKeys(Password);
		  Wait.wait2Second();
		 Wait.wait3Second();
		 d.findElement(By.xpath("//input[@id='btnLogon']")).click();
		/* testresultdata.put("2", new Object[] { 1d,
	              "TC1 - Login into Incenter",
	              "Login Successfully", "Pass" }); }
			catch
			  (Throwable t) {
	              testresultdata.put("2", new Object[] { 1d,
	            		  "TC1 - Login into Incenter",
	    	              "Login Successfully", "Fail" });
	           }*/
		 Wait.wait2Second();
		 
		 d.switchTo().frame("header");
		 Wait.wait2Second();
		 d.findElement(By.xpath("//input[@id='rptrMenu_btnMenuItem_3']")).click();
		 d.switchTo().defaultContent();
		 d.switchTo().frame("main");
		 Wait.wait2Second();
		 d.findElement(By.xpath("//a[@id='rptrMenu_lbtnAltMenuItem_1']")).click();
		 Wait.wait2Second();
		 d.switchTo().defaultContent();
		 d.switchTo().frame("main");
		 d.findElement(By.xpath("//*[@id='btnNew']")).click();
		 Wait.wait2Second();
		/* d.findElement(By.xpath("//input[@id='btnNew']")).click();*/ 
		 d.findElement(By.xpath("//*[@id='txtSeasonName']")).clear();
		 d.findElement(By.xpath("//*[@id='txtSeasonName']")).sendKeys(Season_Name);
		Select dd1 = new Select(d.findElement(By.xpath("//select[@id='drpActive']")));
		dd1.selectByVisibleText(Status);
		 
		Wait.wait2Second();
		d.findElement(By.xpath("//td//a/img")).click();
		/*d.findElement(By.xpath("//*[@id='txtDateStart']")).sendKeys(Start_Date);
		d.findElement(By.xpath("//*[@id='txtDateEnd']")).sendKeys(End_Date);
		d.findElement(By.xpath("//*[@id='btnSave']")).click();*/
		Wait.wait2Second();
		String StartDate = d.findElement(By.xpath("//table[@class='datepicker-table-condensed table-condensed']/tbody")).getText();
		System.out.println(StartDate);
		String[] handle = StartDate.split(" ");
		System.out.println(handle [0]);
		System.out.println(handle [1]);
		
		
		
		
		

	}
	  
	  
	  
	  
	  
	  @AfterClass
		public void stop() {
			setupAfterSuite();
			stopDriver();
		}

		@DataProvider(name = "testParameterData", parallel = false)
		public static Object[][] testParameterData(Method method) throws Exception {

			initialize();
			Object data[][] = TestUtil.getData(datatable_suite1, "Seasons");
			return data;
		}
		 
	  
}