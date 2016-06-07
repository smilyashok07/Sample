package innRoad.innCenter.suite;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import innRoad.innCenter.base.Wait;


public class Navigation {
	WebDriver wd;
       
		
	   @BeforeTest
	   
	   public void beforeTest()
	   {

			System.setProperty("webdriver.chrome.driver", "U:\\eclipse\\InnRoad_DataDrivenFramework\\Lists Formats\\Drivers\\chromedriver.exe");
	           wd = new ChromeDriver();		
		        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   }
		   
		
		  
		
		   @Test
		   
		   public void Test() throws InterruptedException
		   {     
			wd.get("http://training.innroad.com/");
	        wd.findElement(By.id("txtclientCode")).click();
	        wd.findElement(By.id("txtclientCode")).clear();
	        wd.findElement(By.id("txtclientCode")).sendKeys("itng");
	        wd.findElement(By.id("txtLoginID")).click();
	        wd.findElement(By.id("txtLoginID")).clear();
	        wd.findElement(By.id("txtLoginID")).sendKeys("Pravallika");
	        wd.findElement(By.id("txtUserPassword")).click();
	        wd.findElement(By.id("txtUserPassword")).clear();
	        wd.findElement(By.id("txtUserPassword")).sendKeys("Test@1234");
	        wd.findElement(By.id("btnLogon")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Tape Chart']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='New Quote']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Guest History']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Groups']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_accounts']/a/img")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Statements']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_2")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_3")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_4")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_5")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_guest_services']/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_0")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_1")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_2")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_inventory']/a/img")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_0")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_1")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Rates']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_3")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Distribution']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']/li[6]/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='nav_des']//a[normalize-space(.)='Setup']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_0")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_1")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Taxes']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_3")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_4")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_5")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_6")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_admin']/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_0")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_1")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='sec_nav']//span[.='Roles']")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//ul[@class='nav_des']/li[7]/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_night_audit']/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.xpath("//li[@id='head_reports']/a")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_0")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_1")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_2")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_3")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_4")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_5")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("ucNavSecondary_rptrNavMain_lbtnNavMainItem_6")).click();
	        Wait.wait10Second();
	        wd.findElement(By.id("Span1")).click();
	        Wait.wait10Second();
	       
		   }
	        
	        
	      
	      
	        @AfterTest
	        
	        public void afterTest()
	        {
	        	 
		        wd.findElement(By.id("logoutLinkMobile")).click();
		   
		        wd.quit();
	        }
	       
	       
	        
	        
		

	}



