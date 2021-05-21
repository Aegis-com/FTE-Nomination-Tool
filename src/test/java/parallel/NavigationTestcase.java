package parallel;
import fte.pageobjects.NavigationPageObjects;
import fte.utility.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavigationTestcase {
	
	private NavigationPageObjects topNaviBar = new NavigationPageObjects(DriverFactory.getDriver());

	@When("user is in Dashboard")
	public void user_is_in_dashboard() {
		topNaviBar.clicksMSCloudAcceleratorProgramLink();
	}

	@Then("click on the Nominate Link")
	public void click_on_the_nominate_link() {
		topNaviBar.clicksNominateLink();
	}

	@Then("click on the Approvals Link")
	public void click_on_the_approvals_link() {
		topNaviBar.clicksApprovalLink();
	}

	@Then("click on the My Nomination Link")
	public void click_on_the_my_nomination_link() {
		topNaviBar.clicksMyNominationLink();
	}

	@Then("click on the Workshop Eligibility Link")
	public void click_on_the_workshop_eligibility_link() {
		topNaviBar.clicksWorkShopEligibilityLink();
	}

	@Then("LogOut")
	public void log_out() {
	    topNaviBar.clicksProfileButton();
	    topNaviBar.clicksLogOutLink();
	}
	
}
