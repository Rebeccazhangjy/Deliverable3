package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CreateAccount {
	
/**
 * As a user who don’t have an account
 * I want to create a new account
 * so that I can keep record of all my post history
 */
	
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Craigslist Pittsburgh
	@Before
	public void setUp() throws Exception {
		driver.get("http://pittsburgh.craigslist.org/");
	}
	
	//	Given I’m on the main page
	//	And I am not logged in 
	//	When I click apts/housing
	//	And I click account
	//	Then I have an option to create an account
	
	@Test
	public void testCreateAccountOption(){
		driver.findElement(By.cssSelector("a.apa > span.txt")).click();
		driver.findElement(By.linkText("account")).click();
		String create = driver.findElement(By.xpath("(//h4[@class='ban'])[2]")).getText();
		assertEquals(create, "Create a craigslist account");

	}
	
	//	Given I’m on the main page 
	//	And I am not logged in
	//	When I click apts/housing
	//	And I click account
	//	And I type in my email address
	//	Then I get a message saying that I have created an account with my email address

	
	@Test
	public void testCreatedAccount(){
		driver.findElement(By.cssSelector("a.apa > span.txt")).click();
		driver.findElement(By.linkText("account")).click();
		driver.findElement(By.id("emailAddress")).clear();
		driver.findElement(By.id("emailAddress")).sendKeys("zyj_1_2_3@sina.com");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		String email = driver.findElement(By.xpath("(//p)")).getText();
		assertTrue(email.contains("zyj_1_2_3@sina.com"));
	}


}
