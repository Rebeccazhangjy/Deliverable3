package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * As a user who wants to rent an apartment
 * I want to browse information about different apartment available
 * so that I can look for which one I want
 */
	
public class FindApt {
	
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for Craigslist Pittsburgh
	@Before
	public void setUp() throws Exception {
		driver.get("http://pittsburgh.craigslist.org/");
	}
	
	//	Given I’m on the apartments / housing rentals page 
	//	When I type in “north oakland” in the search bar
	//	And click search
	//	Then I should be able to browse apartments and houses available in Oakland area

	@Test
	public void testCreateAccount(){
		driver.findElement(By.cssSelector("a.apa > span.txt")).click();
		driver.findElement(By.id("query")).clear();
		driver.findElement(By.id("query")).sendKeys("north oakland");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		String no = driver.findElement(By.id("query")).getAttribute("value");
		assertEquals(no, "north oakland");
		
	}
	
	//	Given I’m on the apartments / housing rentals page 
	//	When I choose “1+ bedrooms” in the “all bedrooms” box
	//	Then I should be able to browse apartments and houses with more than one bedroom
	
	@Test
	public void testOneBR(){
		
		driver.findElement(By.cssSelector("a.apa > span.txt")).click();
		Select select = new Select(driver.findElement(By.name("bedrooms")));
		select.selectByVisibleText("1+ bedrooms");
		String br = select.getFirstSelectedOption().getText();
		assertEquals(br, "1+ bedrooms");

	}



}
