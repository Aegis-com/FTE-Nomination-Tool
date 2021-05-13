package fte.pageobjects;

import org.openqa.selenium.support.PageFactory;
import fte.utility.ConfigReader;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {
	
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	// Locators of Login page:
	private By profileButton = By.xpath("//a[@class='profile-menu-button ng-star-inserted']");
	private By rippleLink = By.xpath("//a[@class='ripplelink']");
	private By emailId = By.xpath("//input[@type='email']");
	private By next = By.xpath("//input[@type='submit']");
	private By usePassLink = By.xpath("//a[text()='Use your password instead']");
	private By authentication = By.id("FormsAuthentication");
	private By password = By.id("passwordInput");
	private By signIn = By.id("submitButton");
	private By token = By.xpath("//span[text()='Sign in with your phone or token device']");
	private By textOfLandingPage = By.xpath("//div[text()='Microsoft Cloud Accelerator Program']");
	
	// Constructor of the page and Pagefactory	
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// page actions: features(behavior) of the page the form of methods:
	
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	public void launchURL() {
		String URL = prop.getProperty("url");
		driver.get(URL);
		

	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void clicksProfileButton() {
		driver.findElement(profileButton).click();
		driver.findElement(rippleLink).click();
	}

	public void enterUserName() {
		String username = prop.getProperty("emailId");
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(next).click();
	}

	public void clicksTheAuthenButton() {

		if (driver.findElement(usePassLink).isDisplayed()) {
			driver.findElement(usePassLink).click();
		} else {
			driver.findElement(authentication).click();
		}
	}

	public void enterPassword() {
		String pwd = prop.getProperty("password");
		driver.findElement(authentication).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
	}

	public void clicksPhoneTokenAuthetication() {
		driver.findElement(token).click();
	}

	public String getTextOfLandingPage() {
		return driver.findElement(textOfLandingPage).getText();

	}
}
