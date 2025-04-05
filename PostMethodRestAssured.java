package StepDefinations;

import java.io.FileNotFoundException;

import com.api.utils.POJOUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.*;

public class PostMethodRestAssured
{
	@Given("user has access to Post URL {string}")
	public void user_has_access_to_post_url(String string) throws JsonProcessingException, FileNotFoundException {
		POJOUtility.CreateJSONObjectFromEmployeeClassObject();
	}

	@When("user should Post responce")
	public void user_should_post_responce() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should get Post the response code {int}")
	public void user_should_get_post_the_response_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user validates the response which get from post")
	public void user_validates_the_response_which_get_from_post() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}