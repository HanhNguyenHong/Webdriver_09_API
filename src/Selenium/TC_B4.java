package Selenium;			
			
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;			
import org.openqa.selenium.firefox.FirefoxDriver;			
import org.testng.annotations.AfterTest;			
			

public class TC_B4 {			
WebDriver driver;			
			
@BeforeTest			
public void beforeTest() {			
	driver = new FirefoxDriver();		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	driver.manage().window().maximize();		
	driver.get("http://live.guru99.com/");	
	
}		


//Test Script 01: Login empty
@Test
public void TC_01() throws InterruptedException  {
   //Để trống Password,Email 
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
    driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("");
    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
    driver.findElement(By.xpath("//input[@title='Email Address']")).clear();
    driver.findElement(By.xpath("//input[@id='pass']")).clear();
     Thread.sleep(3000);
    driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
   //Verify error message xuất hiện tại 2 field
    String emailRequired = driver.findElement(By.xpath("//li[1]//div[1]//div[1]")).getText();
    AssertJUnit.assertEquals(emailRequired, "This is a required field.");  
    String passwwordRequired = driver.findElement(By.xpath("//li[1]//div[1]//div[1]")).getText();
    AssertJUnit.assertEquals(passwwordRequired, "This is a required field.");  
    
}  


//Test Script 02: Login with Email invalid  
@Test
public void TC_02() {
	driver.findElement(By.xpath("//img[@class='large']")).click(); 
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("123434234@12312.123123");
    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
	driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	String emailRequired = driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid email address. For example jo')]")).getText();
    AssertJUnit.assertEquals(emailRequired, "Please enter a valid email address. For example johndoe@domain.com.");  
	
}

//Test Script 03: Login with Password < 6 character
@Test
public void TC_03() {
	driver.findElement(By.xpath("//img[@class='large']")).click(); 
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("automation@gmail.com");
    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	String PassRequired = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
    AssertJUnit.assertEquals(PassRequired, "Please enter 6 or more characters without leading or trailing spaces.");  
}
//Test Script 04: Login with Password incorrect
@Test
public void TC_04() {
	driver.findElement(By.xpath("//img[@class='large']")).click(); 
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("automation@gmail.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
	driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	String PassRequired = driver.findElement(By.xpath("//li[@class='error-msg']//ul//li")).getText();
    AssertJUnit.assertEquals(PassRequired, "Invalid login or password.");  
}

//Test Script 05: Create an account
@Test
public void TC_05() {
    driver.findElement(By.xpath("//img[@class='large']")).click(); 
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Hanh");
	driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Hong");
	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Nguyen");
	driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("hihi22442@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	String LoginRequired = driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
    AssertJUnit.assertEquals(LoginRequired, "Thank you for registering with Main Website Store.");
	driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
	driver.findElement(By.xpath("//a[@title='Log Out']")).click();
}
@AfterTest			 
public void afterTest() {			
	driver.quit();		
}			
			
}			
			
			
			
			
			
			
			