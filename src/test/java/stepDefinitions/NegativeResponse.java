package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeResponse {
	Response r;
		@Given("API for the foreign exchanges")
		public void api_for_the_foreign_exchanges() throws Throwable{
			r=RestAssured.given().when().get("https://api.ratesapi.io/api/");
			 System.out.println(r.getBody().toString());
		}

		@When("posted with correct Informations")
		public void posted_with_correct_informations() throws Throwable{
			 RestAssured.given().when().get("https://api.ratesapi.io/api/").then().log().all();
		}

		@Then("validate the positive response code received")
		public void validate_the_positive_response_code_received() throws Throwable{
			Assert.assertEquals(r.getContentType(),"application/json");
			Assert.assertEquals(r.getStatusLine(),"HTTP/1.1 400 Bad Request");
			Assert.assertEquals(r.getStatusCode(), 400);
		}
}
