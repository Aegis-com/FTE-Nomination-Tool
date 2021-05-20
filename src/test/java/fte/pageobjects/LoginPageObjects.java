package fte.pageobjects;

import org.openqa.selenium.support.PageFactory;
import fte.utility.ConfigReader;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {

	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	static boolean Selected;

	// Locators of Login page:
	private By profileButton = By.xpath("//a[@class='profile-menu-button ng-star-inserted']");
	private By rippleLink = By.xpath("//a[@class='ripplelink']");
	private By emailId = By.xpath("//input[@type='email']");
	private By next = By.xpath("//input[@type='submit']");
	private By usePassLink = By.xpath("//a[text()='Use your password instead']");
	private By passwordBtn = By.id("FormsAuthentication");
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
		getProperty();
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

	public void enterUserName() throws InterruptedException {
		getProperty();
		String username = prop.getProperty("emailId");
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(next).click();
	}

	public void usePasswordInstead() {
		try {
			driver.findElement(usePassLink);
			Selected = true;
		} catch (NoSuchElementException e) {
			Selected = false;
		}
		if (Selected == true) {
			driver.findElement(usePassLink).click();
			driver.findElement(passwordBtn).click();
		} else {
			driver.findElement(passwordBtn).click();
		}
	}

	public void enterPassword() {
		getProperty();
		String pwd = prop.getProperty("password");
		usePasswordInstead();
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
