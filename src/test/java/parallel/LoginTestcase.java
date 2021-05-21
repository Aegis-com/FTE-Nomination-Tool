package parallel;

import org.junit.Assert;
import fte.pageobjects.LoginPageObjects;
import fte.utility.DriverFactory;
import io.cucumber.java.en.*;

public class LoginTestcase {

	private LoginPageObjects login = new LoginPageObjects(DriverFactory.getDriver());
	private static String title;
	private static String text;

	@Given("user is in login page")
	public void user_is_in_login_page() {
		login.launchURL();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = login.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));

	}

	@When("User clicks profile button to login")
	public void user_clicks_profile_button_to_login() {
		login.clicksProfileButton();
	}

	@When("User enters the username and clicks the Next button")
	public void user_enters_the_username_and_clicks_the_next_button() throws InterruptedException {
		login.enterUserName();

	}

	@When("User enters the password and clicks the Sign In button")
	public void user_enters_the_password_and_clicks_the_sign_in_button() throws InterruptedException {
		login.enterPassword();

	}

	@When("User clicks Sign in with your phone or token device")
	public void user_clicks_sign_in_with_your_phone_or_token_device() {
		login.clicksPhoneTokenAuthetication();
	}

	@When("user gets the text from the Homepage")
	public void user_gets_the_text_from_the_homepage() {
		text = login.getTextOfLandingPage();
		System.out.println("Page text is: " + text);

	}

	@Then("page text should be titled as {string}")
	public void page_text_should_be_titled_as(String expectedText) {
		Assert.assertFalse(text.contains(expectedText));
	}

}