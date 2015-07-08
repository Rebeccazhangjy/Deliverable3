package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user who has a wide range of interest
 * I want to save the post
 * so that I can reach it later
 * 
 */


public class Save {
	static WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception{
		
		//login in and go to the main page
		driver.get("https://accounts.craigslist.org/login");
		driver.findElement(By.id("inputEmailHandle")).sendKeys("emma_liu2000@163.com");
		driver.findElement(By.id("inputPassword")).sendKeys("123456asdfgh");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("craigslist")).click();

	}
	
	
	@Test
	public void testSavePost(){
		
		//Given I’m on the Pittsburgh Craigslist main page
		//When I click science/biotech 
		//And I click save search
		//Then I should be able to save all the posts under my saved post
		
		driver.findElement(By.cssSelector("a.sci > span.txt")).click();
		driver.findElement(By.linkText("save search")).click();
		
		//wait for 10 seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// find the element from outside to the row and finally to description
		WebElement e = driver.findElement(By.id("ss"));
		WebElement row1 = e.findElement(By.className("row1"));
		WebElement description = row1.findElement(By.className("description"));
		
		String s = description.getText();
		assertTrue(s.contains("science/biotech"));
		
			
		
		//Check that I am given the option to edit my saved post
		
		WebElement actions = row1.findElement(By.className("actions"));
		WebElement edit = driver.findElement(By.className("edit"));
		assertTrue(edit.isDisplayed());

		
		//Check that I am given the option to delect my saved post
		WebElement delete = actions.findElement(By.className("delete"));
		assertTrue(delete.isDisplayed());
		
		//Given I’ve saved the post regarding to science/biotech 
		//When I click on the all post under saved science/biotech
		//Then I should be directed to the post and there is a link of science/biotech in the page

		driver.findElement(By.linkText("all posts")).click();

		WebElement reset = driver.findElement(By.linkText("reset"));
		assertTrue(reset.isDisplayed());
		
		
		

				

	}
	
	
	



}
