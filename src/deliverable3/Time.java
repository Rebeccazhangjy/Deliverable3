package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user who wants to search event by time
 * I want to select the date I want
 * so that I can minimize the searching result
 */


public class Time {
	static WebDriver driver = new HtmlUnitDriver();
	
	@Before
	public void setUp() throws Exception{
		driver.get("https://accounts.craigslist.org/login");
		driver.findElement(By.id("inputEmailHandle")).sendKeys("emma_liu2000@163.com");
		driver.findElement(By.id("inputPassword")).sendKeys("123456asdfgh");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("craigslist")).click();

	}
	
	
	@Test
	public void testNextDay(){
		
		//Given I’ve already logged in 
		//And on the Pittsburgh Craigslist main page
		//When I select 9th of July
		//Then I should be directed to the posts that happens through now to 9th of July

		driver.findElement(By.linkText("9")).click();
		driver.findElement(By.linkText("next day >>")).click();
		WebElement e = driver.findElement(By.xpath("//span[@class='cur_day daybubbles']"));

		String s = e.getText();
		assertTrue(s.contains("jul 10"));
		driver.findElement(By.linkText("account")).click();
		driver.findElement(By.linkText("log out")).click();


	}
	
	@Test
	public void testSelectDate(){
		
		//Given I’ve already logged in 
		//And on the Pittsburgh Craiglist main page
		//When I select 9th of July
		//And click on next day
		//Then I should be directed to the posts that happens through now to 10th of July
		
		
		driver.findElement(By.linkText("9")).click();
		WebElement e = driver.findElement(By.xpath("//span[@class='cur_day daybubbles']"));

		String s = e.getText();
		assertTrue(s.contains("jul 9"));


	}
	



}
