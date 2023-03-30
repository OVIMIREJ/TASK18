package com.walletHub.testCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.FailedLoginException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.tools.ant.launch.Launcher;
import org.apache.tools.ant.taskdefs.Input;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.walletHub.pages.*;

public class facebookTest {

	//import the selenium WebDriver
	private WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {

		//locate where the Edge Driver is
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\chromedriver.exe");


		// Navigating to the url
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// 2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
		driver.get("https://selenium-blog.herokuapp.com");
		// Test 1. Verify the user input the right url and its on the right webpage
		if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
			//Pass
			System.out.println("Corrrect Webpage");
		else
			//Fail
			System.out.println("Wrong Webpage");
		Thread.sleep(5000);
		// Maximize the browser
		driver.manage().window().maximize();
		//Click on Signup button to open the Signup page
		driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
	}

	@Test (priority = 0)
	public void positiveSignup() throws InterruptedException {
		//Test 7. Verify that user is successfully signed up when valid details are inputted.
		//Input username on the username field
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div[2]/input")).sendKeys("abiererfgdd63");
		// 6. Input email on the email field
		driver.findElement(By.name("user[email]")).sendKeys("testindshtgsgdy@yopmail.com");
		// 7. Locate the password field and Input your password on the username field
		driver.findElement(By.name("user[password]")).sendKeys("Edgggrgs123");
		// 8. Click on the signup button
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(5000);
	}

	@Test (priority = 1)
	public void clickUser1Item() throws InterruptedException {
		//Test 9. Click on Maegan on the list page
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
		//Test 2. Verify that when user clicks on the signup button, the user id directed to the signup page
		String expectedUrl = "https://selenium-blog.herokuapp.com";
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.contains(expectedUrl))
			//Pass
			System.out.println("Corrrect Webpage");
		else
			//Fail
			System.out.println("Wrong Webpage");
		Thread.sleep(5000);
	}

	@Test (priority = 2)
	public void verifyItem() throws InterruptedException {
		// Search for an item Using (Python with Selenium) and confirm that it is present
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
		String expectedPageUrl = "/users/1";
		String actualPageUrl = driver.getCurrentUrl();
		if (actualPageUrl.contains(expectedPageUrl))
			//Pass
			System.out.println("Corrrect User1Page");
		else
			//Fail
			System.out.println("Wrong User1Page");
		Thread.sleep(5000);
	}

	@Test (priority = 3)
	public void logoutSuccessfully() throws InterruptedException {
		// Click on Logout
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
		//Test 10: Verify that when the user logout he/she is directed back to the login page
		String expectedTitle = "AlphaBlog";
		String actualTitle = driver.getCurrentUrl();
		if(actualTitle.contains(expectedTitle))
			//Pass
			System.out.println("Corrrect Webpage");
		else
			//Fail
			System.out.println("Wrong Webpage");


	}

	@Test (priority = 4)
	public void NegativeSignup() throws InterruptedException {
		// Click on the signup button to open the signup page
		driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
		Thread.sleep(5000);
		//Test 3. Verify that user cannot sign up with username less than 3 character
		//Input username on the username field
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div[2]/input")).sendKeys("ah");
		// 6. Input email on the email field
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys("testingqa@yopmailoore.com");
		// 7. Locate the password field and Input your password on the username field
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/div[2]/input")).sendKeys("Eswewedsdd123");
		// 8. Click on the signup button
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[4]/div/input")).click();
		Thread.sleep(5000);
	}

	@AfterTest
	public void closeBrowser() {
		// 12. Quit the browser
		driver.quit();

	}

}
