package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic05_Button_RadioButton_Checkbox_Alert {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait    waitExplicit;
	private Alert alert;
    
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  waitExplicit = new WebDriverWait(driver, 30);
	  js = (JavascriptExecutor) driver;  
  }
  
  @Test  
  public void TC_01() throws Exception {  
	//Step 01 - Truy cập vào trang: http://live.guru99.com/
	//Step 02 - Click vào link My Account dưới footer (Sử dụng Javascript Executor code)
		driver.get("http://live.guru99.com/");
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")));
		Thread.sleep(5000);
	//Step 03 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/login/
		String loginURL = "http://live.guru99.com/index.php/customer/account/login/";
		Assert.assertEquals(driver.getCurrentUrl(), loginURL);
		System.out.println("URl: " + loginURL);
	//Step 04 - Click vào button CREATE AN ACCOUNT (Sử dụng Javascript Executor code)	
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@title='Create an Account']")));
		Thread.sleep(5000);
	//Step 06 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/create/
		String createURL = "http://live.guru99.com/index.php/customer/account/create/";
		Assert.assertEquals(driver.getCurrentUrl(), createURL);
  }
 
  @Test
  public void TC_02() {
	  driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
	  WebElement Checkbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
	  js.executeScript("arguments[0].click()", Checkbox);
	  //thay vi dung selenium click thi ta dung javascript de click vì thằng input kia bị ẩn VÀ thẻ label thì không thể dùng isSelect() được
	  Assert.assertTrue(Checkbox.isSelected());
	  
	  js.executeScript("arguments[0].click()", Checkbox);
	  Assert.assertFalse(Checkbox.isSelected());
  }

  
  @Test
  public void TC_03() throws InterruptedException {	 
	  driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
   //Step 02 - Click vào radiobutton:  2.0 Petrol, 147kW (Thẻ input ko được sử dụng thuộc tính id) 
	  WebElement element = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
	  js.executeScript("arguments[0].click()", element);
   //Step 03 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
	  if (element.isSelected()) {
	  } else {
		js.executeScript("arguments[0].click()", element);
	  		 }
	  Assert.assertTrue(element.isSelected());
  }
 @Test
  public void TC_04() throws Exception {
	 //Step 01-02
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();	
	//Step 03 - Verify message hiển thị trong alert là: I am a JS Alert  
	  Alert alert = driver.switchTo().alert();
	  String textOnAlert = alert.getText();
	  Assert.assertEquals(textOnAlert, "I am a JS Alert");
	  Thread.sleep(3000);
	//Step 04 - Accept alert và verify message hiển thị tại Result là:  You clicked an alert successfully  
	  alert.accept();
	  WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
	  Assert.assertEquals(result.getText(), "You clicked an alert successfully"); 
  }
@Test
public void TC_05() throws InterruptedException{	
     //Step 01-02
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();	  
    //Step 03 - Verify message hiển thị trong alert là: I am a JS Confirm
	  Alert ConfirmConfirm = driver.switchTo().alert();
	  String AlertConfirm = alert.getText();
	  Assert.assertEquals(AlertConfirm, "I am a JS Alert");
	  Thread.sleep(3000);	
    //Step 04 - Cancel alert và verify message hiển thị tại Result là:  You clicked: Cancel	
	  alert.accept();
	  WebElement resultalert = driver.findElement(By.xpath("/p[@id='result']"));
	  Assert.assertEquals(resultalert.getText(), " You clicked: Cancel"); 	  
}

@Test
public void TC_06() throws InterruptedException{	
   //Step 01-02
	driver.get("https://daominhdam.github.io/basic-form/index.html");
	driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();	  
  //Step 03 - Verify message hiển thị trong alert là: I am a JS prompt
	  Alert alertprompt = driver.switchTo().alert();
	  String Alertprompt = alertprompt.getText();
	  Assert.assertEquals(Alertprompt, "I am a JS prompt");
	  Thread.sleep(3000);
  //Step 04 - Nhập vào text bất kì (daominhdam) và verify message hiển thị tại Result là:  You entered: daominhdam
	  alert.sendKeys("HanhNguyen tester");
	  alert.accept();
	  Thread.sleep(3000);
	  WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
	  Assert.assertEquals(result.getText(), "You entered: HanhNguyen tester"); 
  }
@Test
public void TC_07() throws InterruptedException{	
	//Step 02 - Handle authentication alert vs user/pass: admin/ admin
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	//Step 03 - Verify message hiển thị sau khi login thành công:
	Alert alertlogin = driver.switchTo().alert();
    String Alertlogin = alertlogin.getText();
    Assert.assertEquals(Alertlogin, "I am a JS prompt");
  Thread.sleep(3000);
	
	
	
	
}
@AfterTest
  public void afterTest() {
	  driver.quit();
  }
}