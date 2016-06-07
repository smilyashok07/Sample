package innRoad.innCenter.config;

import org.openqa.selenium.By;

public class OR {

	public static By username = By.id("txtUserName");
	public static By pwd = By.id("txtPassword");
	public static By Loginbtn = By.id("btnLogin");
	
	
	
	//Promotion code in BE
	public static By Promo_Code_link=By.xpath("//*[@id='divPromoCodehref']/a");
	public static By Promotioncodeobject = By.id("AvailabilitySearch1_txtPromoCode");
	
	
	// Selecting Year from calendar
	
	public static By Calendar_Header=By.className("calender_header");
	public static By Getting_Years=By.className("months_yearstrip");
	
	//Selecting Month from calendar
	
	public static By Getting_Months=By.className("small_big_container_strip");
	
	//Selecting Dates
	
	public static By Getcheckintext=By.xpath("//span[@class='widget_label_2']");
	public static By GetCheckinDates=By.xpath("//span[2]/span");
	public static By GetCheckoutDate=By.xpath("//div[3]/span[2]/span");
	public static By GetCheckouttext=By.xpath("//div[3]/span/span");

	
	//Test Mode
	
	public static By Test_Mode_Strip = By.id("MainContent_lblTestModeMsg");
	
	//Find My reservation
	
	public static By Find_Reservation_link=By.id("AvailabilitySearch1_lnkMyReservations");
	
	//Promotion code
	
	
	//Select Rooms
	
	public static By Rooms_Checkin_Date=By.id("AvailabilitySearch1_lbkChkInDate");
	public static By Rooms_Checkout_Date=By.id("AvailabilitySearch1_lbkChkOutDate");
	public static By Rooms_Checkin_Week=By.id("AvailabilitySearch1_lblChkInDayOfTheWeek");
	public static By Rooms_Checkout_Week=By.id("AvailabilitySearch1_lblChkOutDayOfTheWeek");
	public static By Rooms_Checkout_Mon_Year=By.id("AvailabilitySearch1_lblChkOutMonthAndYear");
	public static By Rooms_Checkin_Mon_Year=By.id("AvailabilitySearch1_lblChkInMonthAndYear");
	public static By Rooms_Checkin_Text=By.xpath("//div[@id='AvailabilitySearch1_chkInPanel']/fieldset/legend");
	public static By Rooms_Checkout_Text=By.xpath("//div[@id='AvailabilitySearch1_chkOutPanel']/fieldset/legend");
	public static By Rooms_Property_Name=By.id("AvailabilitySearch1_lblPropertyName");
	public static By Rooms_Num_of_Nights=By.xpath("//div[@class='nights summery_box_container_div1']");
	public static By Rooms_Adchild=By.xpath("//div[@class='guest_adchild summery_box_container_div1']");
	public static By Rooms_Verify_Promotion_Code=By.xpath("//*[@id='AvailabilitySearch1_promocode_summery_box_container_div1']/span");
	public static By Rooms_Rack_Rate_Info=By.xpath("//*[@id='lnkMoreInfo']");
	public static By Rooms_Get_Rack_Rate_title=By.xpath("//*[@id='TB_ajaxWindowTitle']");
	public static By Rooms_Get_Rate_Name=By.xpath("//*[@id='Div8']/table/tbody/tr[2]/td[2]");
	public static By Rooms_Get_Policy_Name=By.xpath("//*[@id='Div8']/table/tbody/tr[4]/td[2]");
	public static By Rooms_Close_Rack_Rate_popup=By.xpath("//*[@id='TB_closeWindowButton']");
	public static By Rooms_get_Rate=By.xpath("//*[@id='MainContent_rptrPropertyList_lblMinRate_0']");
	public static By Rooms_get_Nighty_rate=By.xpath("//*[@id='MainContent_rptrPropertyList_rptPropertyRooms_0_tdRateDescription_0']/span");
	public static By Rooms_Click_Select=By.xpath("//*[@id='MainContent_rptrPropertyList_rptPropertyRooms_0_btnSelect_0']");
	
	
	//Enhance your stay
	
	public static By Enhance_page_title=By.xpath("//*[@id='Div3']/div/div[3]/div/div[2]/div[2]/div[2]/div/span[1]");
	
}
