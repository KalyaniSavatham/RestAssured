package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest {
	Response r;
	  @Given("API for foreign exchange")
	  public void api_for_foreign_exchange() throws Throwable{
		  r=RestAssured.given().when().get("https://api.ratesapi.io/api/latest");
		  System.out.println(r.getBody().toString());
	  }

	  @When("posted with correct Information")
	  public void posted_with_correct_information() throws Throwable {
		 RestAssured.given().when().get("https://api.ratesapi.io/api/latest").then().log().all();

	  }

	  @Then("validate positive response code received")
	  public void validate_positive_response_code_received() throws Throwable {
		  Assert.assertEquals(r.getStatusCode(), 200);
		  Assert.assertEquals(r.getStatusLine(), "HTTP/1.1 200 OK");
	  }

}
