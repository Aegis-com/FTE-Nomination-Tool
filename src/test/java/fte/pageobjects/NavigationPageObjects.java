package fte.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavigationPageObjects {
	private WebDriver driver;
	// Constructor of the page and Pagefactory
	public NavigationPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators of Navigation:
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Microsoft Cloud Accelerator Program')]")
	private WebElement MSCloudAcceleratorProgramLink;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Nominate')]")
	private WebElement nominateLink;

	@FindBy(how = How.XPATH, using = "//div[@class = 'layout-topbar-grid']//span[contains(text(),'Approvals')]")
	private WebElement approvalLink;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Nominations')]")
	private WebElement myNominationLink;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Workshop Eligibility')]")
	private WebElement workShopEligibilityLink;

	@FindBy(how = How.XPATH, using = "//a[@class='profile-menu-button ng-star-inserted']")
	private WebElement profileButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Logout')]")
	private WebElement logOutLink;

	// page actions: features(behavior) of the page the form of methods:
	public void clicksMSCloudAcceleratorProgramLink() {
		MSCloudAcceleratorProgramLink.click();
	}

	public void clicksNominateLink() {
		nominateLink.click();
	}

	public void clicksApprovalLink() {
		approvalLink.click();
	}

	public void clicksMyNominationLink() {
		myNominationLink.click();
	}

	public void clicksWorkShopEligibilityLink() {
		workShopEligibilityLink.click();
	}

	public void clicksProfileButton() {
		profileButton.click();
	}

	public void clicksLogOutLink() {
		logOutLink.click();
	}

}
