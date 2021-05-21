package parallel;

import fte.pageobjects.NominationFormPageObjects;
import fte.utility.DriverFactory;
import io.cucumber.java.en.*;

public class NominationFormTestcases {

	private NominationFormPageObjects nominate = new NominationFormPageObjects(DriverFactory.getDriver());
	
	
	@Then("user click on the Nominate customer link directs to Nominate page")
	public void user_click_on_the_nominate_customer_link_directs_to_nominate_page() {
		nominate.nominateCustomer();
	}

	@Then("User fills the Partner information details")
	public void user_fills_the_partner_information_details() throws InterruptedException {
		nominate.selectareafiled();
		nominate.fillPartnerdetails();
		
	}

	@Then("User fills the Customer nomination details")
	public void user_fills_the_customer_nomination_details() {
		nominate.fillcustomerNomdetails();
	}

	@Then("User fills the engagement details")
	public void user_fills_the_engagement_details() throws InterruptedException  {
		nominate.fillengagementdetails();
	}

	@Then("Submit the Nomination")
	public void submit_the_nomination() throws InterruptedException {
		nominate.submitNomination();
	}

}