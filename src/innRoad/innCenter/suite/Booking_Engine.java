package innRoad.innCenter.suite;

import java.io.Console;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import innRoad.innCenter.base.BaseTest;
import innRoad.innCenter.util.TestUtil;
import innRoad.innCenter.base.Wait;
import innRoad.innCenter.config.OR;

public class Booking_Engine extends BaseTest {
	
	public String Weekday;
	
	public String GetCheckintext;
	
	public String GetCheckinDate;
	
	public String GetCheckouttext;
	
	public String GetCheckoutDate;
	
	
	
	
	
	  @Test(dataProvider = "testParameterData")
	  public void testUntitled( String Https,String TCN, String PageTitle, String ArrivalDate, String DepartureDate, String Adultcount, String childrenscount,
			  
			  
			  String Promocode, String Promotionvalue, String Room_PageTitle, String Test_Mode_Verification, String propertyName, String RackRateTitle,
			  String GetRateName, String GetpolicyName, String Rate
			  
			  
			  
			  ) throws Exception {
		  
		  setupBeforeSuite(TCN);
		  
		  //Launches Application
		  try
		  {
		  fillLogin();
		  
		  verifyURL(Https);
		  
		  testresultdata.put("2", new Object[] { 1d,
	              "TC1 - Verify site loaded or not ",
	              "System sucessfully navigate to the Site", "Pass" }); }
		  
		  catch (Throwable t) {
              testresultdata.put("2", new Object[] { 1d,
		      "TC1 - Verify site loaded or not",
		      "System Failed to navigate to the site", "Fail" });
           }
		  
		  
		  // Verifying page title
		  
		  try
		  {
			  
		  String pagetitle=d.getTitle();
		  Assert.assertEquals(PageTitle, pagetitle);
			  
			  testresultdata.put("3", new Object[] { 2d,
		              "TC2 - Verify page title ",
		              "Page title verification Successfully", "Pass" }); }
		  catch
		  (Throwable t) {
              testresultdata.put("3", new Object[] { 2d,
		      "TC2 - Verify page title",
		      "System Failed to verify page title", "Fail" });
           }
		  
		  
		  
		  //Selecting arrival Dates
		  
		  try
		 {
		  selectingMonth("Jun");
		  SelectingDates(ArrivalDate,DepartureDate);
		    GetCheckintext = d.findElement(OR.Getcheckintext).getText();
			GetCheckinDate = d.findElement(OR.GetCheckinDates).getText();
			GetCheckouttext= d.findElement(OR.GetCheckouttext).getText();
			GetCheckoutDate= d.findElement(OR.GetCheckoutDate).getText();
			 
			 System.out.println(GetCheckintext +GetCheckinDate+ GetCheckouttext + GetCheckoutDate );
		  testresultdata.put("4", new Object[] { 3d,
              "TC3 - Verify whether user able to select arrivalDate and Departuredate ",
              "System should allow user to select arrival and departure dates", "Pass" }); }
	     catch(Throwable t) {
         testresultdata.put("4", new Object[] { 3d,
	      "TC3 - Verify whether user able to select arrival and Departuredate",
	      "User Failed to select arrival and departure dates", "Fail" });
     }
		  
		  
		  
		
		  
		  
		  //Select Adults and childrens 
		  
		 try
			{
			
			int Adcount = Integer.parseInt(Adultcount);
			
			for(int i=1; i<= Adcount-1; i++)
			{
				d.findElement(By.xpath("//a[@class='incRoomCount flL grayGradient'] [@data-bind='click: incAdults']")).click();
				Wait.wait2Second();
			}
			testresultdata.put("5", new Object[] { 4d,
		              "TC4 - Verify whether user able to select adultcount ",
		              "System should allow user to select adultcount", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("5", new Object[] { 4d,
		      "TC4 - Verify whether user able to select adultcount",
		      "User Failed to select Adultcount", "Fail" });
	       }
		  
		  
		  try
			{
		
			  int ChildCount = Integer.parseInt(childrenscount);
			for(int i=1; i<= ChildCount; i++)
			{
			d.findElement(By.xpath("//a[@class='incRoomCount flL grayGradient'] [@data-bind='click: incChildren']")).click();
			Wait.wait2Second();
			}
			testresultdata.put("6", new Object[] { 5d,
		              "TC5 - Verify whether user able to select childrens",
		              "System should allow user to select childrens", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("6", new Object[] { 5d,
		      "TC5 - Verify whether user able to select childrens",
		      "User failed to select childrenscount ", "Fail" });
	       }
		  
		  
		  
		  try
		  {
			  promotioncode(Promotionvalue);
			 
			  testresultdata.put("7", new Object[] { 6d,
		              "TC6 - Verify entered promotion code text",
		              "System Sucessfully verified entered promotion code", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("7", new Object[] { 6d,
		      "TC6 - Verify entered promotion code text",
		      "System failed to verify promotion code text", "Fail" });
	       }
		  
		  
		  //Checkavailability
		  
		  try
		  {
			  d.findElement(By.xpath("//*[@id='AvailabilitySearch1_btnAvailabilitySearch']")).click();
			  Wait.wait15Second();
		  
		  testresultdata.put("8", new Object[] { 7d,
	              "TC7 - Verify by clicking on Check availability",
	              "User able to click check availability", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("8", new Object[] { 7d,
	      "TC7 - Verify by clicking on Check availability",
	      "User unable to click check availability", "Fail" });
       }
	  
		  
		 //Select Rooms page
		  
		 // Verify page title
		  
		  try
		  {
			  
		  String Room_Page_Title=d.getTitle();
		  System.out.println(Room_Page_Title);
		  Assert.assertEquals(Room_PageTitle, Room_Page_Title);
		  verifyURL(Https);
			  
			  testresultdata.put("9", new Object[] { 8d,
		              "TC8 - Verify page title and Https for Select Rooms page ",
		              "Page title and https verification Successfully", "Pass" }); }
		  catch
		  (Throwable t) {
              testresultdata.put("9", new Object[] { 8d,
		      "TC8 - Verify page title and https for Select Rooms page",
		      "System Failed to verify page title and https", "Fail" });
           }
		  
		  
		  //Test Mode Verification 
		  try
		  {
		  Test_Mode_Verification(Test_Mode_Verification);
		  
		  testresultdata.put("10", new Object[] { 9d,
	              "TC9 - Verify page title for Select Rooms page ",
	              "Page title verification Successfully", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("10", new Object[] { 9d,
	      "TC9 - Verify page title for Select Rooms page",
	      "System Failed to verify page title", "Fail" });
       }
		  
		 //Verifying stay details in Select Room page
		  
		  try
		  {
		  //Checkin date
		  String Checkindate = d.findElement(OR.Rooms_Checkin_Date).getText();
		  String[] Get_Arrival_Date= GetCheckinDate.split(",");
		  String[] Get_Arrival_Date2=Get_Arrival_Date[1].trim().split(" ");
		  Assert.assertEquals(Checkindate, Get_Arrival_Date2[1]);
		  
		  //Checkout date
		  String Checkoutdate = d.findElement(OR.Rooms_Checkout_Date).getText();
		  String[] Get_Depature_Date=GetCheckoutDate.split(",");
		  String[] Get_Depature_Date2=Get_Depature_Date[1].trim().split(" ");
		  Assert.assertEquals(Checkoutdate, Get_Depature_Date2[1]);
		  
		  //Checkin Week
		  
		  String checkinWeek = d.findElement(OR.Rooms_Checkin_Week).getText();
		  String GetCheckinWeek = Get_Arrival_Date[0];
		  Assert.assertEquals(checkinWeek, GetCheckinWeek);
		  
		  //Checkout Week
		  
		  String CheckoutWeek = d.findElement(OR.Rooms_Checkout_Week).getText();
		  String GetCheckoutWeek = Get_Depature_Date[0];
		  Assert.assertEquals(CheckoutWeek, GetCheckoutWeek);
		  
		  //Checkin Month and Year
		  
		  String Checkin_Mon_Year=d.findElement(OR.Rooms_Checkin_Mon_Year).getText();
		  String Split_Year_Checkin=Get_Arrival_Date[2].trim().substring(2);
		  String Exp_Checkin_Mon_Year=Get_Arrival_Date2[0]+"'"+Split_Year_Checkin;
		  Assert.assertEquals(Checkin_Mon_Year, Exp_Checkin_Mon_Year);
		  
		  
		  //Checkout Month and Year
		  
		  String Checkout_Mon_Year=d.findElement(OR.Rooms_Checkout_Mon_Year).getText();
		  String Split_Year_Checkout=Get_Depature_Date[2].trim().substring(2);
		  String Exp_Checkout_Mon_Year=Get_Depature_Date2[0]+"'"+Split_Year_Checkout;
		  Assert.assertEquals(Checkout_Mon_Year, Exp_Checkout_Mon_Year);
		  
		  
		  //Check In and Check out text
		  
		  String Checkin_Text=d.findElement(OR.Rooms_Checkin_Text).getText();
		  String Checkout_Text=d.findElement(OR.Rooms_Checkout_Text).getText();
		  Assert.assertEquals(Checkin_Text, "CHECK IN");
		  Assert.assertEquals(Checkout_Text, "CHECK OUT");
		  
		  
		  //Property Name
		   String Property_Name=d.findElement(OR.Rooms_Property_Name).getText();
		   Assert.assertEquals(Property_Name, propertyName);
		   
		   
		   //Number of nights
		   
		   int ArrivalDates = Integer.parseInt(ArrivalDate);
		   int DepartureDates = Integer.parseInt(DepartureDate);
		   int Num_of_Nights=ArrivalDates-DepartureDates;
		   System.out.println("Num_of_Nights:"+Num_of_Nights);
		   String Cov_int_to_String=Integer.toString(Num_of_Nights);
		   System.out.println("Cov_int_to_String:"+Cov_int_to_String);
		   String spliting_Minus=Cov_int_to_String.substring(1);
		   System.out.println("spliting_Minus:"+spliting_Minus);
		   int value = Integer.parseInt(spliting_Minus);
		   
		   if(value>1)
		   {
			   String Numofnights=d.findElement(OR.Rooms_Num_of_Nights).getText();
			   System.out.println("Numofnights:"+Numofnights);
			   String Exp_Number_of_Nights=spliting_Minus+" "+"Nights";
			   System.out.println("Exp_Number_of_Nights:"+Exp_Number_of_Nights);
			   Assert.assertEquals(Numofnights, Exp_Number_of_Nights);
		   }
		   else
		   {
			   String Numofnights=d.findElement(OR.Rooms_Num_of_Nights).getText();
			   System.out.println("Numofnights:"+Numofnights);
			   String Exp_Number_of_Nights=spliting_Minus+" "+"Night";
			   System.out.println("Exp_Number_of_Nights:"+Exp_Number_of_Nights);
			   Assert.assertEquals(Numofnights, Exp_Number_of_Nights);
		   }
		   
		   //Number of Adults and and childs
		   
		   int Cov_int_Adult = Integer.parseInt(Adultcount);
		   
		   if(Cov_int_Adult>1)
		   {
			   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
			   String[] Split_Adults_Childs=GetAdchild.split(",");
			   String Adults_Count_Verification= Adultcount+" "+ "Adults";
			   Assert.assertEquals(Split_Adults_Childs[0].trim(), Adults_Count_Verification);
		   }
		   else
		   {
			   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
			   String[] Split_Adults_Childs=GetAdchild.split(",");
			   String Adults_Count_Verification= Adultcount+" "+ "Adult";
			   Assert.assertEquals(Split_Adults_Childs[0].trim(), Adults_Count_Verification);
		   }
		   
		  int cov_int_Child= Integer.parseInt(childrenscount);
		  
		  if(cov_int_Child>1)
		   {
			   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
			   String[] Split_Adults_Childs=GetAdchild.split(",");
			   String Adults_Count_Verification= childrenscount+" "+ "Children";
			   Assert.assertEquals(Split_Adults_Childs[1].trim(), Adults_Count_Verification);
		   }
		   else
		   {
			   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
			   String[] Split_Adults_Childs=GetAdchild.split(",");
			   String Adults_Count_Verification= childrenscount+" "+ "Child";
			   Assert.assertEquals(Split_Adults_Childs[1].trim(), Adults_Count_Verification);
		   }
		  
		  
		  // verifying promotion code Promotion code
		  
		  String GetPromoCode=d.findElement(OR.Rooms_Verify_Promotion_Code).getText();
		  String[] split_Get_Promocode=GetPromoCode.split(" ");
		  String final_Promo_code=split_Get_Promocode[0]+" "+split_Get_Promocode[1]+" "+split_Get_Promocode[2]+" "+Promotionvalue;
		  Assert.assertEquals(GetPromoCode, final_Promo_code);
		  
		  testresultdata.put("11", new Object[] { 10d,
	              "TC10 - Verifying stay details in Select Room page ",
	              "stay details are displayed fine", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("11", new Object[] { 10d,
	      "TC10 - Verifying stay details in Select Room page",
	      "System Failed to verify stay details", "Fail" });
       }
		  
		  
		  //Click and verify Rack rate information
		  
		  try
		  {
			  d.findElement(OR.Rooms_Rack_Rate_Info).click();
			  Wait.wait3Second();
			  String Get_RackRate_Title=d.findElement(OR.Rooms_Get_Rack_Rate_title).getText();
			  Assert.assertEquals(Get_RackRate_Title, RackRateTitle);
			  String Get_Rate_Name=d.findElement(OR.Rooms_Get_Rate_Name).getText();
			  Assert.assertEquals(Get_Rate_Name, GetRateName);
			  String Get_Policy_Name= d.findElement(OR.Rooms_Get_Policy_Name).getText();
			  Assert.assertEquals(Get_Policy_Name, GetpolicyName);	
			  d.findElement(OR.Rooms_Close_Rack_Rate_popup).click();
			  Wait.wait3Second();
		  testresultdata.put("12", new Object[] { 11d,
	              "TC11 - Verifying More info for Rack rate ",
	              "System should displays rack rate pop up with all details and should verify", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("12", new Object[] { 11d,
	      "TC11 - Verifying more info for Rack Rate",
	      "System Failed to open pop up and failed to verify details", "Fail" });
       }
		  
		  
		  //Rate verification in Select Rooms page
		  
		  try
		  {
			  String getRate=d.findElement(OR.Rooms_get_Rate).getText();
			  System.out.println(getRate);
			  Assert.assertEquals(getRate, Rate);
			  System.out.println(Rate);
			  String get_Nighty_Rate=d.findElement(OR.Rooms_get_Nighty_rate).getText();
			  System.out.println(get_Nighty_Rate);
			  Assert.assertEquals(get_Nighty_Rate, Rate);
			  
			  testresultdata.put("13", new Object[] { 12d,
		              "TC12 - Verifying Rate cost",
		              "System should display as per specified rate in inncenter", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("13", new Object[] { 12d,
		      "TC12 - Verifying Rate Cost",
		      "System failed to display as per specified rate", "Fail" });
	       }
		  
		  
		  //Click on Select button in Select rooms
		  
		  try
		  {
			  d.findElement(OR.Rooms_Click_Select).click();
			  Wait.wait10Second();
			  verifyURL(Https);
			  String Enhance_Pagetitle=d.findElement(OR.Enhance_page_title).getText();
			  Assert.assertEquals(Enhance_Pagetitle, "Enhance Your Stay");
			  testresultdata.put("14", new Object[] { 13d,
		              "TC13 - Verifying by clicking on select button",
		              "System should navigate to the Enchance your stay page", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("14", new Object[] { 13d,
		      "TC13 - Verifying by clicking on Select button",
		      "System failed to navigate to the enchance your stay page", "Fail" });
	       }
		  
		  
		  //Verify Stay details in Enhance your stay
		  
		  try
		  {
		  
			  //Checkin date
			  String Checkindate = d.findElement(OR.Rooms_Checkin_Date).getText();
			  String[] Get_Arrival_Date= GetCheckinDate.split(",");
			  String[] Get_Arrival_Date2=Get_Arrival_Date[1].trim().split(" ");
			  Assert.assertEquals(Checkindate, Get_Arrival_Date2[1]);
			  
			  //Checkout date
			  String Checkoutdate = d.findElement(OR.Rooms_Checkout_Date).getText();
			  String[] Get_Depature_Date=GetCheckoutDate.split(",");
			  String[] Get_Depature_Date2=Get_Depature_Date[1].trim().split(" ");
			  Assert.assertEquals(Checkoutdate, Get_Depature_Date2[1]);
			  
			  //Checkin Week
			  
			  String checkinWeek = d.findElement(OR.Rooms_Checkin_Week).getText();
			  String GetCheckinWeek = Get_Arrival_Date[0];
			  Assert.assertEquals(checkinWeek, GetCheckinWeek);
			  
			  //Checkout Week
			  
			  String CheckoutWeek = d.findElement(OR.Rooms_Checkout_Week).getText();
			  String GetCheckoutWeek = Get_Depature_Date[0];
			  Assert.assertEquals(CheckoutWeek, GetCheckoutWeek);
			  
			  //Checkin Month and Year
			  
			  String Checkin_Mon_Year=d.findElement(OR.Rooms_Checkin_Mon_Year).getText();
			  String Split_Year_Checkin=Get_Arrival_Date[2].trim().substring(2);
			  String Exp_Checkin_Mon_Year=Get_Arrival_Date2[0]+"'"+Split_Year_Checkin;
			  Assert.assertEquals(Checkin_Mon_Year, Exp_Checkin_Mon_Year);
			  
			  
			  //Checkout Month and Year
			  
			  String Checkout_Mon_Year=d.findElement(OR.Rooms_Checkout_Mon_Year).getText();
			  String Split_Year_Checkout=Get_Depature_Date[2].trim().substring(2);
			  String Exp_Checkout_Mon_Year=Get_Depature_Date2[0]+"'"+Split_Year_Checkout;
			  Assert.assertEquals(Checkout_Mon_Year, Exp_Checkout_Mon_Year);
			  
			  
			  //Check In and Check out text
			  
			  String Checkin_Text=d.findElement(OR.Rooms_Checkin_Text).getText();
			  String Checkout_Text=d.findElement(OR.Rooms_Checkout_Text).getText();
			  Assert.assertEquals(Checkin_Text, "CHECK IN");
			  Assert.assertEquals(Checkout_Text, "CHECK OUT");
			  
			  
			  //Property Name
			   String Property_Name=d.findElement(OR.Rooms_Property_Name).getText();
			   Assert.assertEquals(Property_Name, propertyName);
			   
			   
			   //Number of nights
			   
			   int ArrivalDates = Integer.parseInt(ArrivalDate);
			   int DepartureDates = Integer.parseInt(DepartureDate);
			   int Num_of_Nights=ArrivalDates-DepartureDates;
			   System.out.println("Num_of_Nights:"+Num_of_Nights);
			   String Cov_int_to_String=Integer.toString(Num_of_Nights);
			   System.out.println("Cov_int_to_String:"+Cov_int_to_String);
			   String spliting_Minus=Cov_int_to_String.substring(1);
			   System.out.println("spliting_Minus:"+spliting_Minus);
			   int value = Integer.parseInt(spliting_Minus);
			   
			   if(value>1)
			   {
				   String Numofnights=d.findElement(OR.Rooms_Num_of_Nights).getText();
				   System.out.println("Numofnights:"+Numofnights);
				   String Exp_Number_of_Nights=spliting_Minus+" "+"Nights";
				   System.out.println("Exp_Number_of_Nights:"+Exp_Number_of_Nights);
				   Assert.assertEquals(Numofnights, Exp_Number_of_Nights);
			   }
			   else
			   {
				   String Numofnights=d.findElement(OR.Rooms_Num_of_Nights).getText();
				   System.out.println("Numofnights:"+Numofnights);
				   String Exp_Number_of_Nights=spliting_Minus+" "+"Night";
				   System.out.println("Exp_Number_of_Nights:"+Exp_Number_of_Nights);
				   Assert.assertEquals(Numofnights, Exp_Number_of_Nights);
			   }
			   
			   //Number of Adults and and childs
			   
			   int Cov_int_Adult = Integer.parseInt(Adultcount);
			   
			   if(Cov_int_Adult>1)
			   {
				   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
				   String[] Split_Adults_Childs=GetAdchild.split(",");
				   String Adults_Count_Verification= Adultcount+" "+ "Adults";
				   Assert.assertEquals(Split_Adults_Childs[0].trim(), Adults_Count_Verification);
			   }
			   else
			   {
				   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
				   String[] Split_Adults_Childs=GetAdchild.split(",");
				   String Adults_Count_Verification= Adultcount+" "+ "Adult";
				   Assert.assertEquals(Split_Adults_Childs[0].trim(), Adults_Count_Verification);
			   }
			   
			  int cov_int_Child= Integer.parseInt(childrenscount);
			  
			  if(cov_int_Child>1)
			   {
				   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
				   String[] Split_Adults_Childs=GetAdchild.split(",");
				   String Adults_Count_Verification= childrenscount+" "+ "Children";
				   Assert.assertEquals(Split_Adults_Childs[1].trim(), Adults_Count_Verification);
			   }
			   else
			   {
				   String GetAdchild=d.findElement(OR.Rooms_Adchild).getText();
				   String[] Split_Adults_Childs=GetAdchild.split(",");
				   String Adults_Count_Verification= childrenscount+" "+ "Child";
				   Assert.assertEquals(Split_Adults_Childs[1].trim(), Adults_Count_Verification);
			   }
			  
			  
			  // verifying promotion code Promotion code
			  
			  String GetPromoCode=d.findElement(OR.Rooms_Verify_Promotion_Code).getText();
			  System.out.println("GetPromoCode:" + GetPromoCode);
			  String[] split_Get_Promocode=GetPromoCode.split(" ");
			  String final_Promo_code=split_Get_Promocode[0]+" "+split_Get_Promocode[1]+" "+split_Get_Promocode[2]+" "+Promotionvalue;
			  System.out.println("final_Promo_code:" + final_Promo_code);
			  Assert.assertEquals(GetPromoCode, final_Promo_code);
			  testresultdata.put("15", new Object[] { 14d,
		              "TC14 - Verifying stay details in ehance your stay",
		              "System should verify stay details successfully", "Pass" }); }
		  catch
		  (Throwable t) {
	          testresultdata.put("15", new Object[] { 14d,
		      "TC14 - Verifying by clicking on Select button",
		      "System failed to verify stay details", "Fail" });
	       }
		  
		  
		  //
		  
		  
		  
		  //Verify the calendar formatt(Calendar should be Us formatt(sunday to sat)
		  /*try
		  {
		  
		  for(int i=1; i<=7; i++)
		  {
			Weekday= d.findElement(By.xpath("//td[2]/div[2]/div["+i+"]")).getText();
			System.out.println(Weekday);
		 }
		 
		  Assert.assertEquals("Su", Weekday);
		  Assert.assertEquals("Mo", Weekday);
		  Assert.assertEquals("Tu", Weekday);
		  Assert.assertEquals("We", Weekday);
		  Assert.assertEquals("Th", Weekday);
		  Assert.assertEquals("Fr", Weekday);
		  Assert.assertEquals("Sa", Weekday);

		  testresultdata.put("4", new Object[] { 3d,
	              "TC3 - Verify Calendar Weekdays format",
	              "System verified weekdays format successfully", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("4", new Object[] { 3d,
	      "TC3 - Verify Calendar Weekdays format",
	      "System Failed to verify Weekdays format", "Fail" });
       }*/
		  
		  
		  
		  
		  //Selecting Year
		  
		 // selectingYear("2018");
		  
		  //selectingMonth("Dec");
		  
		 
		  
		  
		
		  
		  
		  
		  
		 /* //Promotion code
		  try
		  {
		  
		  if(Promo.equals("Yes"))
		  {
			  promotioncode(Promotionvalue);
		  }
		  
		  testresultdata.put("5", new Object[] { 4d,
	              "TC4 - Verify by entering promotion code in the promotion code text box",
	              "System should allow user to enter promotion code", "Pass" }); }
	  catch
	  (Throwable t) {
          testresultdata.put("5", new Object[] { 4d,
	      "TC4 - Verify by entering promotion code in the promotion code text box",
	      "User failed or skipped to enter Promotion code", "Fail" });
       }
		  */
		  
		  
		  // Verifying Current Date
		  
		/*  String CurrentDate = d.findElement(By.xpath("//div[@class='current_date']//span[1]")).getTagName();
		  
		  System.out.println(CurrentDate);*/
		  
		  
		  
		  
		  //Find my reservations
		  
		  d.findElement(OR.Find_Reservation_link).click();
		  Wait.wait5Second();
		  
		  
		  
		  
	  }
	  
	  @AfterClass
		public void stop() {
			setupAfterSuite();
			stopDriver();
		}

		@DataProvider(name = "testParameterData", parallel = false)
		public static Object[][] testParameterData(Method method) throws Exception {

			initialize();
			Object data[][] = TestUtil.getData(datatable_suite1, "Booking_Engine");
			return data;
		}
	

	
	

}
