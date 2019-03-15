package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_05_Dropdown_list {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
	@Test  
  public void TC_01_Dropdown() {
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
  /*
   * Xử lí HTML
   Step 02 - Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
   Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
   Step 04 - Kiểm tra giá trị đã được chọn thành công
   Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
   Step 06 - Kiểm tra giá trị đã được chọn thành công
   Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
   Step 08 - Kiểm tra giá trị đã được chọn thành công
   Step 09 - Kiểm tra dropdown có đủ 5 giá trị
   */
       WebElement jobRole01 = driver.findElement(By.xpath("//select[@name='user_job1']"));
       Select jobRoleSelect = new Select(jobRole01);
       
       //Step 02 - Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
       Assert.assertFalse(jobRoleSelect.isMultiple());
       //Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
       jobRoleSelect.selectByVisibleText("Automation Tester");
       //Step 04 - Kiểm tra giá trị đã được chọn thành công
       Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(),"Automation Tester");
       //Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
       jobRoleSelect.selectByValue("manual");
       //Step 06 - Kiểm tra giá trị đã được chọn thành công
       Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(),"Manual Tester");
       //Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
       jobRoleSelect.selectByIndex(3);
       //Step 08 - Kiểm tra giá trị đã được chọn thành công
       Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(),"Mobile Tester");
       //Step 09 - Kiểm tra dropdown có đủ 5 giá trị
       Assert.assertEquals(jobRoleSelect.getOptions().size(),5);
	}
  @Test
  public void TC_02_CustomerDropdow() {
	  /*
	   * Xử lí Xử lí Custom
	   Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectmenu/default.html
       Step 02 - Chọn item cuối cùng: số 19
       Step 03 - Kiểm tra item đã được chọn thành công
	   */
	  driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	  
	  
	  
	
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}