package StepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.api.utils.Responce;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CompleteRestAssured {

	@Given("user has access to endpoint {string}")
	public void user_has_access_to_endpoint(String url) {
		Responce.responce().asString();
	}

	@When("user print responce")
	public void user_print_responce() {
		System.out.println(Responce.responce().asString());
		System.out.println("Responce printed sucessfully");
	}

	@Then("user should get the response code {int}")
	public void user_should_get_the_response_code(Integer int1) {

		System.out.println("Response code:" + Responce.responce().getStatusCode());
		Assert.assertEquals(Responce.responce().statusCode(), 200);
		String statusline = Responce.responce().getStatusLine();
		System.out.println(statusline);
	}

	@Then("user validates the response with JSON schema")
	public void user_validates_the_response_with_json_schema() {
		String responseString = Responce.responce().asString();
		Assert.assertEquals(responseString.contains("George"), true);
		System.out.println("George String responce printed sucessfully");
	}

	@Then("user validates the header")
	public void user_validates_the_header() {
		String contentType = Responce.responce().getHeader("Content-Type");
		Headers headersList = Responce.responce().getHeaders();
		for (Header header : headersList) {
			System.out.println(header.getName() + ":" + header.getValue());
		}
		Assert.assertEquals(contentType, "application/json; charset=utf-8", "Header content type mismatch.");
	}

	@When("I have the firstName and LastName")
	public void getDataTabelValue(DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);
		for (List<String> columns : rows) {
			String firstName = columns.get(0);
			String lastName = columns.get(1);

			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: " + lastName);
		}

		List<Map<String, String>> rows1 = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : rows1) {
			String firstName = row.get("firstName");
			String lastName = row.get("lastName");

			// Perform your actions with firstName and lastName
			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: " + lastName);

			// If you need to make a request or perform any other operations
			// makeRequestWithNames(firstName, lastName);
		}
	}

	@When("validaation using jsonpath")
	public void validaation_using_jsonpath() {
		JsonPath jsonPathView = Responce.responceBody().jsonPath();
		String firstName = jsonPathView.get("data[0].first_name");
		System.out.println("email address:" + jsonPathView.get("data[1].avatar"));
		Assert.assertEquals(firstName, "George", "Check for presense of firstname as George");
	}
}
