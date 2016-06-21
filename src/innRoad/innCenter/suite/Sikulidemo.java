package innRoad.innCenter.suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class Sikulidemo {
	WebDriver driver;

	@BeforeClass
	public void setup()
	{
		/*System.setProperty("webdriver.chrome.driver","U:\\Selenium\\IE&Chrome Drivers\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();*/
		driver = new FirefoxDriver();
			driver.manage().window().maximize();
	}
@Test
public void Test()throws InterruptedException, FindFailed
{
	driver.get("https://test.innroad.com/be/paynesville/property.aspx");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 2000);");
	Screen s = new Screen();
	Pattern image1 = new Pattern("C:\\SikuliX\\Image1.png");
  // s.wait(image1, 2000);
	s.find(image1);
	
	
}
@AfterClass
public void teardown()
{
	driver.quit();
}
}
