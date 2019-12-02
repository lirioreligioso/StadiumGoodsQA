package cloud.stadiumgoods.stage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests1a {

	@Test
	public void loginTest() throws Exception {

		System.out.println("Starting Part 1.1 Test");

//		===Objective=== 
//		A.  Create a simple POI data-driven Framework for the login page.(https://stage.stadiumgoods.cloud/customer/account/login/)
//		B.  Test Data is given in excel (Please use attached data sheet)
//		C.  Validate if the user is able to login using the user credentials.

//		Create driver

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

// 		Locate file location

		File src = new File("..\\Datafeed\\Authorization.xlsx");
		System.out.println("Located datafeed");

		System.out.println("-----------------------");

		FileInputStream fis = new FileInputStream(src);

// 		Load total workbook

		XSSFWorkbook wb = new XSSFWorkbook(fis);

//		Locate sheet1

		XSSFSheet sheet1 = wb.getSheetAt(0);

//		Locate username1

		String username1 = sheet1.getRow(1).getCell(0).getStringCellValue();

		System.out.println("Data from Username1 is " + username1);

//		Locate password1

		String password1 = sheet1.getRow(1).getCell(1).getStringCellValue();

		System.out.println("Data from Password1 is " + password1);

		System.out.println("-----------------------");

//		Locate username2

		String username2 = sheet1.getRow(2).getCell(0).getStringCellValue();

		System.out.println("Data from Username2 is " + username2);

//		Locate password2

		String password2 = sheet1.getRow(2).getCell(1).getStringCellValue();

		System.out.println("Data from Password2 is " + password2);

		System.out.println("-----------------------");

//		Open authorization page for username1

		String username1url = "https://stage.stadiumgoods.cloud/customer/account/login/";
		driver.get(username1url);
		System.out.println("Opening page: " + username1url);

//		Enter username1

		WebElement enterusername1 = driver.findElement(By.xpath("//html[@id='top']//input[@id='email']"));
		enterusername1.sendKeys(username1);

//		Enter password1

		WebElement enterpassword1 = driver.findElement(By.xpath("//html[@id='top']//input[@id='pass']"));
		enterpassword1.sendKeys(password1);

//		Click login button

		WebElement logInButton1 = driver.findElement(By.xpath("//html[@id='top']//button[@id='send2']"));
		logInButton1.click();

		System.out.println("Authorization info for Username1 is entered.");

//		Verification for username1

		/*
		 * WebElement successMessage1 =
		 * driver.findElement(By.cssSelector(".hello > strong"));
		 * System.out.println("User1 Test Passed: " + successMessage1);
		 */

		System.out.println("-----------------------");

//		Open authorization page for username2

		String username2url = "https://stage.stadiumgoods.cloud/customer/account/login/";
		driver.get(username2url);
		System.out.println("Opening page: " + username2url);

//		Enter username2

		WebElement enterusername2 = driver.findElement(By.xpath("//html[@id='top']//input[@id='email']"));
		enterusername2.sendKeys(username2);

//		Enter password2

		WebElement enterpassword2 = driver.findElement(By.xpath("//html[@id='top']//input[@id='pass']"));
		enterpassword2.sendKeys(password2);

//		Click login button

		WebElement logInButton2 = driver.findElement(By.xpath("//html[@id='top']//button[@id='send2']"));
		logInButton2.click();

		System.out.println("Authorization info for Username2 is entered.");

//		Verification for username2		

		/*
		 * WebElement successMessage2 =
		 * driver.findElement(By.cssSelector(".hello > strong"));
		 * System.out.println("User2 Test Passed:" + successMessage2);
		 */

// 		Close browser

		driver.quit();

	}
}
