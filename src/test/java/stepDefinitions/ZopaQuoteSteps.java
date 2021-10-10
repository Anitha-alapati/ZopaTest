package stepDefinitions;

import org.apache.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ZopaQuoteSteps {
	
	ZopaQuoteUtils zopa = new ZopaQuoteUtils();
	
	public Response postWrongQuoteUrl;
	

	@Given ("I wanted to register as a new Qanat member")
	public void i_wanted_to_register_as_a_new_Qanat_member() {
		
		Response res = zopa.postNewMember();
		res.prettyPrint();
		
		assertThat(res.getStatusCode()).as("status code is not as expected")
		.isEqualTo(HttpStatus.SC_CREATED);

	}
	
	
	@And("I am a registered Qanat member")
	public void i_am_a_registered_qanat_member() {
		
		Response response = zopa.getRegisteredMember();
		response.prettyPrint();
		
		assertThat(zopa.getRegisteredMember().getStatusCode()).as("status code is not as expected")
		.isEqualTo(HttpStatus.SC_OK);
		
	}

	@When("I request a quote with currentSalary: {int}, amountBorr: {int}, termLenght: {int}")
	public void i_request_a_quote_with_current_salary_amount_borr_term_lenght(Integer CurrSal, Integer AmtBrrw, Integer TrmLen) throws Exception {
		
		Response postQuote = zopa.postQuote(CurrSal, AmtBrrw, TrmLen);
		postQuote.prettyPrint();

		System.out.println("Responce Code:- "+postQuote.getStatusCode());
		assertThat(postQuote.getStatusCode()).isEqualTo(200);
	}
	
		
	@Then("I receive the quoteoffered {string}")
	public void i_receive_the_quoteoffered(String quoteOff) {
		
		System.out.println(quoteOff);
		System.out.println(Boolean.parseBoolean(quoteOff));
		System.out.println(zopa.getQuoteOffered());
		assertThat(zopa.getQuoteOffered()).isEqualTo(Boolean.parseBoolean(quoteOff));

	}
	
	@When("I request a quote with currentSalary: {int}, amountBorr: {int}, termLenght: {int} from wrong zopaQuoteUrl")
	public void i_request_a_quote_with_current_salary_amount_borr_term_lenght_from_wrong_zopa_quote_url(Integer CurrSal, Integer AmtBrrw, Integer TrmLen) throws Exception {
		
		postWrongQuoteUrl = zopa.postWrongQuoteUrl(CurrSal, AmtBrrw, TrmLen);
		postWrongQuoteUrl.prettyPrint();

		System.out.println("Responce Code:- "+postWrongQuoteUrl.getStatusCode());
		assertThat(postWrongQuoteUrl.getStatusCode()).isEqualTo(404);
	}
	

	@Then("I receive the statusCode {int}")
	public void i_receive_the_status_code(Integer statusCode) {
		

		
		System.out.println("Responce Code:- "+postWrongQuoteUrl.getStatusCode());
		assertThat(postWrongQuoteUrl.getStatusCode()).isEqualTo(404);
		
	}

		
}

