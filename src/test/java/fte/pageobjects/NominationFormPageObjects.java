package fte.pageobjects;

import org.openqa.selenium.support.PageFactory;
import fte.utility.ConfigReader;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NominationFormPageObjects {

	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	// Locators of Nomination Form page:
	// Step 1 Partner information
	private By nominateCustomer = By.xpath("//a[text()='Nominate customer']");
	private By dropdownSelect = By.xpath("//div//label[text()='Select']");
	private By listOFDropdown = By.xpath("//li[@role='option']");
	private By addMPNID = By.xpath("//span[text()='Add MPNID']");
	private By txtPartnerSrch = By.xpath("//div//input[@formcontrolname='txtPartnerSrch']");
	private By searchIcon = By.xpath("//span[@class='ui-button-icon-left ui-clickable ui-icon-search']");
	private By checkBox = By.xpath("//div[@class= 'ui-radiobutton-box ui-widget ui-state-default']");
	private By mpnidSumbit = By.xpath("//span[text()='Submit']");
	private By partnerEmail = By.xpath("//input[@placeholder='Enter partner email address']");
	private By checkboxEmail = By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[3]");
	private By partnerExceptionBox = By.xpath("//textarea[@formcontrolname='isExpReasPartnerForm']");
	private By partnerInfoNext = By.xpath("//span[text()='Next']");

	// Step 2. Customer nomination
	private By searchCustomer = By.xpath("//input[@placeholder='Search by customer account name']");
	private By customerEmail = By.xpath("//input[@placeholder='Enter customer email address']");
	private By customerCountry = By.xpath("//input[@placeholder='Search a country']");
	private By enterTenantID = By.xpath("//input[@placeholder='Enter customer Tenant ID/TPID']");
	private By customerNomNext = By.xpath("//span[text()='Next']");

	// Step 3. Engagement details

	private By displyCustomerName = By.xpath("(//div[@class='ui-g-12 ui-md-12 ui-lg-12'])[1]");
	private By drilldownEngagementList = By.xpath("//div[@role='tablist']//a[@tabindex='0']");
	private By listcheckboxes = By
			.xpath("//p-checkbox[@class='listchck ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private By applyCusException = By.xpath("//label[text()='Check here to apply Exception']");
	private By engCustReason = By.xpath("//textarea[@formcontrolname='engCustReason']");
	private By engagementdetNext = By.xpath("//span[text()='Next']");

	// Step 4. Submit nomination

	private By applyMcapException = By.xpath("//label[text()='Check here to apply Exception']");
	private By engMCAPReason = By.xpath("//textarea[@formcontrolname='engMCAPReason']");
	private By fundOnePencil = By.xpath("(//span[@class='ui-button-icon-left ui-clickable fa fa-pencil'])[1]");
	private By fundtext = By.xpath("//input[@type='text']");
	private By checkb = By.xpath("//span[@class='ui-button-icon-left ui-clickable fa fa-check']");
	private By newNominationForm = By.xpath("//span[text()='New nomination']");
	private By submitNomination = By.xpath("(//span[text()='Submit nomination'])[2]");

	// Constructor of the page and Pagefactory
	public NominationFormPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page actions: features(behavior) of the page the form of methods:

	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		String URL = prop.getProperty("url");
		driver.get(URL);
	}

	public void nominateCustomer() {
		driver.findElement(nominateCustomer).click();
		getLoginPageTitle();
	}

	public void selectareafiled() {
		driver.findElement(dropdownSelect).click();
		List<WebElement> testDropDown = driver.findElements(listOFDropdown);
		System.out.println("Size of options:" + " " + testDropDown.size());
		for (WebElement Options : testDropDown) {
			if (Options.getText().equals("CorpHQ")) {
				Options.click();
				break;
			}
		}
	}

	public void fillPartnerdetails() throws InterruptedException {
		driver.findElement(addMPNID).click();
		driver.findElement(txtPartnerSrch).sendKeys("6095461");
		driver.findElement(searchIcon).click();
		driver.findElement(checkBox).click();
		driver.findElement(mpnidSumbit).click();
		Thread.sleep(1000);
		driver.findElement(partnerEmail).sendKeys("mstest_testadmintest@testsam010usorgtest.onmicrosoft.com");
		Thread.sleep(1000);
		driver.findElement(checkboxEmail).click();
		driver.findElement(partnerExceptionBox).sendKeys("Test Partner Exception reason");
		driver.findElement(partnerInfoNext).click();

	}

	public void fillcustomerNomdetails() {
		driver.findElement(searchCustomer).sendKeys("CALTEX AUSTRALIA");
		driver.findElement(customerEmail).sendKeys("NA");
		driver.findElement(customerCountry).sendKeys("Australia");
		driver.findElement(enterTenantID).sendKeys("26da0e1a-1ace-4d46-8ea5-5da117f08417");
		driver.findElement(customerNomNext).click();

	}

	public void fillengagementdetails() throws InterruptedException {
		WebElement Customername = driver.findElement(displyCustomerName);
		String cusname = Customername.getText();
		System.out.println(cusname);
		List<WebElement> listofengagements = driver.findElements(drilldownEngagementList);
		for (WebElement listen : listofengagements) {
			if (!listen.isSelected()) {
				listen.click();
				break;
			}
		}
		List<WebElement> listofcheckboxes = driver.findElements(listcheckboxes);
		for (WebElement list : listofcheckboxes) {
			if (!list.isSelected()) {
				list.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(applyCusException).click();
		driver.findElement(engCustReason).sendKeys("Test customer Exception reason");
		driver.findElement(engagementdetNext).click();
		Thread.sleep(1000);
	}

	public void submitNomination() throws InterruptedException {
		driver.findElement(applyMcapException).click();
		driver.findElement(engMCAPReason).sendKeys("Test MCAP pricing Exception reason");
		Thread.sleep(500);
		driver.findElement(fundOnePencil).click();
		WebElement Fund1 = driver.findElement(fundtext);
		Fund1.clear();
		Fund1.sendKeys("500");
		driver.findElement(checkb).click();
		driver.findElement(newNominationForm).click();

		// driver.findElement(submitNomination).click();

	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
