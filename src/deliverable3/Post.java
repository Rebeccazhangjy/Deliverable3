package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Post {
	
/**
 * As a user who have extra houses to rent
 * I want to post my house information 
 * so that others can check it
 */
	
	static WebDriver driver = new FirefoxDriver();
	
	// Start at the home page for Craigslist Pittsburgh
	@Before
	public void setUp() throws Exception {
		driver.get("http://pittsburgh.craigslist.org/");
	}
	
	//	Given I’m on the main page
	//	When I click “post to classifieds”
	//	Then I should be able to choose a type of “housing offered”

	@Test
	public void testPostHouse(){
		driver.findElement(By.cssSelector("#postlks > li > #post")).click();
		String ho = driver.findElement(By.xpath("//label[4]")).getText();
		assertEquals(ho, "housing offered");
	}
	
	//	Given I’m on the main page
	//	When I click “post to classifieds”
	//	And click apts/housing for rent
	//	Then I should be about to post the house and contact information

	@Test
	public void testPostInfo(){
		driver.findElement(By.cssSelector("#postlks > li > #post")).click();
		driver.findElement(By.xpath("(//input[@name='id'])[4]")).click();
		driver.findElement(By.xpath("(//input[@name='id'])[2]")).click();
		WebElement posting = driver.findElement(By.className("posting"));
		WebElement legend1 = posting.findElement(By.xpath("//fieldset/legend"));
		assertTrue(legend1.isDisplayed());
		WebElement rf = driver.findElement(By.cssSelector("div.row.fields"));
		WebElement legend2 = rf.findElement(By.xpath("//fieldset/legend"));
		assertTrue(legend2.isDisplayed());
	}

}
