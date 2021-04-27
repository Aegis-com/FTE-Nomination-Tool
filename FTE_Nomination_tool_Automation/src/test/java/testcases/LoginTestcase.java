package testcases;


import java.util.Properties;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utility.ConfigReader;
import utility.DriverFactory;

public class LoginTestcase {

	private static String title;
	private static String text;
	private LoginPage loginPage = new pages.LoginPage(DriverFactory.getDriver());
	private ConfigReader configReader;
	Properties prop;
	
	@Given("user is in login page")
	public void user_is_in_login_page() {
		//DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
		DriverFactory.getDriver().get("https://ftenomination-dev.azurewebsites.net/#/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Given("User clicks profile button to login")
	public void user_clicks_profile_button_to_login() {
		loginPage.clicksProfileButton();

	}

	@And("User enters the username and clicks the Next button")
	public void user_enters_the_username_and_clicks_the_next_button() {
		loginPage.enterUserName("v-prakashp@microsoft.com");
		

	}

	@And("User enters the password and clicks the Sign In button")
	public void user_enters_the_password_and_clicks_the_Sign_In_button() {
		loginPage.enterPassword("P_r11akas94h$micro");
	}

	@And("User clicks Sign in with your phone or token device")
	public void user_clicks_sign_in_with_your_phone_or_token_device() {
		loginPage.clicksPhoneTokenAuthetication();
	}

	@And("user gets the text from the Homepage")
	public void user_gets_the_text_from_the_homepage() {
		text = loginPage.getTextOfLandingPage();
		System.out.println("Page text is: " + text);

	}

	@Then("page text should be titled as {string}")
	public void page_text_should_be_titled_as_microsoft_cloud_accelerator_program(String expectedText) {
		Assert.assertTrue(text.contains(expectedText));
	}
}
