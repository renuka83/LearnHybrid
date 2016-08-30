package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report=new ExtentReports("./Reports/LoginPageReport.html",true);
		logger=report.startTest("Verify test Login");
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage()
	{
	
		HomePage home=PageFactory.initElements(driver, HomePage.class);
	    String title=home.getApplicationTitle();
	    Assert.assertTrue(title.contains("Demo Store"));
	    logger.log(LogStatus.PASS, "Home Page loaded and verified");
	    home.clickOnSignInLink();
	    logger.log(LogStatus.INFO, "Click on sign in link");
	    LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	    login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	    logger.log(LogStatus.INFO, "Login to Application");
	    login.verifySignOutLink();	
	    logger.log(LogStatus.PASS, "Signout link is present");
	}
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	    report.endTest(logger);
	    report.flush();
	}

}
