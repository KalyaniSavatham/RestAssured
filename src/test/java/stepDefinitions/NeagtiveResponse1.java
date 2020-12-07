package stepDefinitions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NeagtiveResponse1 {
	Response r;
	@Given("API for foreign exchangess")
	public void api_for_foreign_exchangess() throws Throwable{
		r=RestAssured.given().when().get("https://api.ratesapi.io/api/2010-01-12");
		System.out.println(r.getBody().toString());
	}


	@Test(dataProvider="exchangerates")
	@When("posted with future <date> information")
	public void posted_with_future_date_information(String date) throws Throwable{
		RestAssured.given().when().get("https://api.ratesapi.io/api/"+date).then().log().all();
	}

	@Then("validate positive response code receivedd")
	public void validate_positive_response_code_receivedd() throws Throwable{
		Assert.assertEquals(r.getContentType(), "application/json");

	}
	@DataProvider(name="exchangerates")
	public Object[][] dataProvider() {
		Object[][] date=new Object[3][1];
		
		date[0][0]="2020-12-12";
		date[1][0]="2020-12-05";
		date[2][0]="2019-10-10";
		return date;
	}

}
