package innRoad.innCenter.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng_Learning {
	
	@Test
	
	public void test1() {
		
		System.out.println("Reservation");
		 
	}
	
	@Test
	public void test2(){
		System.out.println("Check in");
	}
	
	@Test
	public void test3(){
		System.out.println("Check Out");
	}
	
	@BeforeMethod
	
	public void beforeMethod() {
		
		System.out.println("Login");
		
	}
	
	@AfterMethod
	
   public void afterMethod() {
		
		System.out.println("Logout");
		
	}
	
	@BeforeTest
	
	

	   public void beforeTest() {
			
			System.out.println("DatabaseConnection");
			
		}
	
	
	@org.testng.annotations.AfterTest
	
	 public void AfterTest() {
			
			System.out.println("Dissconnect");
			
		}

}
