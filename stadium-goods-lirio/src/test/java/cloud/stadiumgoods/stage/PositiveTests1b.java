package cloud.stadiumgoods.stage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests1b {

	@Test
	public void categoryTest() throws Exception {

		System.out.println("Starting Part 1.2 Test");

//		===Objective===  
//		A.  Please verify the number of categories available on the header and (A.2) select a random category from them.
//		B.  In the randomly selected Product listing page/Category page, sort the product by “price” with “Low to High”.
//		C.  Write a test to verify that products are sorted properly in Product Listing page/Category page.

//		Create driver

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.stadiumgoods.com/");

		java.util.List<WebElement> links = driver
				.findElements(By.cssSelector("#header-nav ol.nav-primary > li.level0"));

		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Results (A):  There are a total of " + links.size() + " category headers.");
		System.out.println("-----------------------------------------------------------------------");

		/*
		 * for (int i = 0; i <= links.size(); i++)
		 * 
		 * {
		 * 
		 * System.out.println(links.get(i).getText());
		 * 
		 * }
		 */

		links.get(new Random().nextInt(links.size())).click();
		System.out.println("Results (A.2):  Random link was clicked successfully.");
		System.out.println("-----------------------------------------------------------------------");

//		Click drop-down select menu

		Thread.sleep(8000);
		WebElement sortElm = driver.findElement(By.cssSelector("#sort_by_chosen"));
		Thread.sleep(8000);

		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

// 		Execute the Java Script for the element which we find out
		((JavascriptExecutor) driver).executeScript(js, sortElm);

// 		Click on element

		sortElm.click();

		System.out.println("Results (A.3a):  Initial element is successfully clicked for dropdown menu: " + "\n"
				+ sortElm.getText());
		System.out.println("-----------------------------------------------------------------------");

//		Click drop-down select menu

		Thread.sleep(8000);
		WebElement lowTohigh = driver.findElement(By.cssSelector("#sort_by_chosen > div > ul > li:nth-child(3)"));
		Thread.sleep(8000);

		String js2 = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

// 		Execute the Java Script for the element which we find out
		((JavascriptExecutor) driver).executeScript(js2, lowTohigh);

// 		Click on element

		lowTohigh.click();

		System.out.println(
				"Results (A.3b):  Dropdown is successfully clicked at final point: " + sortElm.getText() + ".");
		System.out.println("-----------------------------------------------------------------------");

		// Close browser

		driver.quit();

	}

}
