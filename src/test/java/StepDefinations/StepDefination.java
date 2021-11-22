package StepDefinations;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import Resoures.TestDataBuild;
import Resoures.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utils {
	ResponseSpecification responcespec;
	RequestSpecification res;
	Response response;

	TestDataBuild data = new TestDataBuild(); // for add place resoures

	@Given("^ADD place PayLoad$")
	public void add_place_Payload() {

		res = given().spec(requestSpecification()).body(data.AddplacePayload());

		response = res.when().post("maps/api/place/add/json").then().spec(responcespec).extract().response();
		String responceStirng = response.asString();
		System.out.println(responceStirng);

		throw new PendingException();
	}

	@When("^user calls \"([^\"]*)\" Method With Post http Api$")
	public void user_calls_Method_With_Post_http_Api(String arg1) throws Throwable {
		responcespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post("maps/api/place/add/json").then().spec(responcespec).extract().response();
	}

	@Then("^the API call is sucess with status code (\\d+)$")
	public void the_API_call_is_sucess_with_status_code(int arg1) throws Throwable {
		assertEquals(response.getStatusCode(), 200);
		throw new PendingException();
	}

	@Then("^\"([^\"]*)\" in responce body is \"([^\"]*)\"$")
	public void in_responce_body_is(String Keyvalue, String Expectedvalue) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(Keyvalue).toString(), Expectedvalue);
	}

}
