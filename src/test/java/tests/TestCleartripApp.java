package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCleartripApp {

	WebDriver driver;

	@Test
	public void Cleartrip() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//1. Open the browser
		driver.get("https://www.cleartrip.com/");
		
		//2. Print COVID-19 message 
		System.out.println(driver.findElement(By.xpath("//div[@class='banner-section br4 light-wood-border mb5 mt5 yellowBg']")).getText());
		
		//3. Click Round trip button
		driver.findElement(By.id("RoundTrip")).click();  
		
		//4. Select London, GB - Heathrow (LHR)
		driver.findElement(By.id("FromTag")).sendKeys("London, GB - Heathrow (LHR)"); 
		
		//5. Select Milan, IT - Malpensa (MXP)
		driver.findElement(By.id("ToTag")).sendKeys("Milan, IT - Malpensa (MXP)");
		
		//6. Click Depart on 
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();  
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div")).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[6]/a")).click();
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active ")).click();
		
		//7. Click Return on 
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div")).click(); 
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		//driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.name("adults"));
		Select select = new Select(driver.findElement(By.name("adults")));     
		select.selectByValue("2");
		
		driver.findElement(By.name("childs"));
		Select select1 = new Select(driver.findElement(By.name("childs")));     
		select1.selectByValue("3");
		
		driver.findElement(By.name("infants"));
		Select select2 = new Select(driver.findElement(By.name("infants")));     
		select2.selectByValue("0");
		
		driver.findElement(By.id("SearchBtn")).click();
	}
}