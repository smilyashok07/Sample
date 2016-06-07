package innRoad.innCenter.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.thoughtworks.selenium.Selenium;

import innRoad.innCenter.config.Config;
import innRoad.innCenter.config.OR;
import innRoad.innCenter.datatable.Xls_Reader;
import innRoad.innCenter.base.Wait;

public class BaseTest {

	public static Xls_Reader datatable_suite1 = null;
	public static WebDriver d = null;
	// define a test result data object
	// Map<String, Object[]> testresultdata;

	// define an Excel Work Book
	static HSSFWorkbook workbook;
	// define an Excel Work sheet
	static HSSFSheet sheet;
	// define a test result data object
	protected static Map<String, Object[]> testresultdata;

	public static void initialize() throws Exception {
		if (Config.browser.equals("FF")) {
			d = new FirefoxDriver();

		} else if (Config.browser.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver",
					"U:\\eclipse\\InnRoad_DataDrivenFramework\\Lists Formats\\Drivers\\IEDriverServer.exe");
			 DesiredCapabilities capab1 =DesiredCapabilities.internetExplorer();  
	           capab1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
	           capab1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
	           d=new InternetExplorerDriver(capab1);       
	           
			
			//d = new InternetExplorerDriver();

		} else if (Config.browser.equals("GC")) {
			System.setProperty("webdriver.chrome.driver",
					"U:\\eclipse\\InnRoad_DataDrivenFramework\\Lists Formats\\Drivers\\chromedriver.exe");
			d = new ChromeDriver();

		}

		datatable_suite1 = new Xls_Reader(System.getProperty("user.dir")
				+ "\\src\\innRoad\\innCenter\\config\\TestData.xlsx");

	}

	
	
	public void stopDriver() {
		d.quit();
	}

	

	public static void setupBeforeSuite(String TCName)
			throws FileNotFoundException, IOException {
		
		// baseUrl = "http://www.seleniummaster.com";
		
		String fileName = "U:\\Innroad_DataDriven\\InnRoad\\InnRoad\\TestResults.xls";
		POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(
				fileName));
		workbook = new HSSFWorkbook(fileSystem);
		// create a new work sheet
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date date = new Date();

		String SheetName = TCName + dateFormat.format(date);

		if (workbook.getNumberOfSheets() != 0) {

			sheet = workbook.createSheet(SheetName);
		} else {
			sheet = workbook.createSheet("Test Result");
		}

		testresultdata = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		testresultdata.put("1", new Object[] { "Test Step Id", "Action",
				"Expected Result", "Actual Result" });

	}

	public static void setupAfterSuite() {
		// write excel file and file name is TestResult.xls
		Set<String> keyset = testresultdata.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = testresultdata.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream("U:\\Innroad_DataDriven\\InnRoad\\InnRoad\\TestResults.xls");
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

	public static void paymentMethod(String CardType, String CardNumber, String ExpriyMonth, String ExpriyYear, String CVV) throws InterruptedException
	{
		
		new Select (d.findElement(By.xpath("//select[@id='MainContent_drpBilling_TypeID']"))).selectByVisibleText(CardType);
		Wait.wait3Second();
		d.findElement(By.xpath("//input[@id='MainContent_txtBilling_AccountNumber']")).sendKeys(CardNumber);
		new Select (d.findElement(By.xpath("//select[@id='MainContent_drpCardExpiryMonth']"))).selectByVisibleText(ExpriyMonth);
		Wait.wait3Second();
		new Select (d.findElement(By.xpath("//select[@id='MainContent_drpCardExpiryYear']"))).selectByVisibleText(ExpriyYear);
		Wait.wait3Second();
		d.findElement(By.xpath("//input[@id='MainContent_txtCVVCode']")).sendKeys(CVV);
		
		
	}
	








public String  DateConversion (String a) throws ParseException 

{
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
    Date d_date = dateFormat.parse(a); 
    String strDate = dateFormat.format(d_date);
    System.out.println("Conversion" +strDate);
	String jim = strDate; 
	return jim;
	
	
}




   
   public static void fillLogin()
			throws InterruptedException {

		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get(Config.url);
		System.out.println("URL   " + Config.url);
		innRoad.innCenter.base.Wait.wait15Second();
		

	}
   
   public static void promotioncode (String data) throws InterruptedException {
	   
	   d.findElement(OR.Promo_Code_link).click();
	   Wait.wait3Second();
	   d.findElement(OR.Promotioncodeobject).clear();
	   Wait.wait2Second();
	   d.findElement(OR.Promotioncodeobject).sendKeys(data);
	   
   }
   
   public static void selectingYear(String data) throws InterruptedException{
	   
	 //Selecting Year
		  
		  d.findElement(OR.Calendar_Header).click();
		  Wait.wait3Second();
		  d.findElement(OR.Calendar_Header).click();
		  Wait.wait3Second();
		  String months_yearstrip = d.findElement(OR.Getting_Years).getText();
		  String [] GetYearSize = months_yearstrip.split("\n");
		  int sizecount = GetYearSize.length;
		  for(int i=1;i<sizecount;i++)
		  {
		  if(GetYearSize[i].equals(data))
		  {
			int value = i+1;
			d.findElement(By.xpath("//div[3]/div/div["+value+"]/span")).click();
			Wait.wait10Second();
		  }
		  }
   }
   
   
   public static void selectingMonth(String data) throws InterruptedException
   {
	   d.findElement(OR.Calendar_Header).click();
	   Wait.wait3Second();
	   String Months_strip = d.findElement(OR.Getting_Months).getText();
	   String [] GetMonthSize = Months_strip.split("\n");
	   int sizecount = GetMonthSize.length;
	   for(int i=1;i<sizecount;i++)
		  {
		  if(GetMonthSize[i].equals(data))
		  {
			int value = i;
			d.findElement(By.xpath("//div[4]/div/div["+value+"]/span")).click();
			Wait.wait10Second();
		  }
		  }
	   
   }


   public static void SelectingDates(String ArrivalDate, String DepartureDate ) throws InterruptedException
   {
	   try
	   {
	   d.findElement(By.xpath("(//div[@id='first']/div/span)["+ArrivalDate+"]")).click();
	   Wait.wait10Second();
	   }
	   catch(Exception e)
	   {
		   d.findElement(By.xpath("(//div[@id='first']/div)["+ArrivalDate+"]")).click();
	   } Wait.wait10Second();
	   
	  
		try
		{
		d.findElement(By.xpath("(//div[@id='first']/div/span)["+DepartureDate+"]")).click();
		 Wait.wait10Second();
		
		}
		catch(Exception e)
		   {
			   d.findElement(By.xpath("(//div[@id='first']/div)["+DepartureDate+"]")).click();
		   } 
   }
   
   
   public static void Test_Mode_Verification(String data){
	   
	   if(d.findElement(OR.Test_Mode_Strip).isDisplayed())
	   {
	   String GetTestMode_Text=d.findElement(OR.Test_Mode_Strip).getText();
	   System.out.println(GetTestMode_Text);
	   
	   if(GetTestMode_Text.equals(data))
	   {
		   System.out.println("Test Mode text is verified Successfully");
	   }
	   else
	   {
		   System.out.println("Failed to verify test mode text");
	   }
	   }
	   else
	   {
		   System.out.println("Test mode text dint displayed");
	   }
   }
   
   public String waitForElement(String item) {
	    WebDriverWait wait = new WebDriverWait(d,30);
	    WebElement element = wait.until(
	                        ExpectedConditions.presenceOfElementLocated(By.id(item)));
	    return item;
	}

   
   public static void verifyURL(String data){
	   
	   if(d.getCurrentUrl().startsWith(data));
   }
}



