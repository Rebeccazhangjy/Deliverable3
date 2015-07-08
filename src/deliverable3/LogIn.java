package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class LogIn {
	static WebDriver driver = new HtmlUnitDriver();
	
	@Before
	public void setUp() throws Exception{
		driver.get("https://accounts.craigslist.org/login");
		
	}
	
	
	//Given I’m on the Pittsburgh Craigslist apartment/housing rental page
	//When I click the account button
	//Then I should be directed to the account sign-in and creation page
	@Test 
	public void testCorrectPassword(){
		
		//send the correct username and password
		driver.findElement(By.id("inputEmailHandle")).sendKeys("emma_liu2000@163.com");
		driver.findElement(By.id("inputPassword")).sendKeys("123456asdfgh");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		
		WebElement f = driver.findElement(By.className("bchead"));
		String name = f.getText();
		assertTrue(name.contains("emma"));
		driver.findElement(By.linkText("log out")).click();

	}
	
	//Given a correct username
	//And an incorrect password
	//When I try to log in with those credentials
	//Then I should receive an error page with “incorrect password entered” on it

	@Test
	public void testIncorrectPassword(){
		
		//send the correct username and incorrect password

		driver.findElement(By.id("inputEmailHandle")).sendKeys("emma_liu2000@163.com");
		driver.findElement(By.id("inputPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		WebElement f = driver.findElement(By.className("error"));
		String incorrect = f.getText();
		assertTrue(incorrect.contains("incorrect"));
	}
	
	
	
	
	
	}
	


