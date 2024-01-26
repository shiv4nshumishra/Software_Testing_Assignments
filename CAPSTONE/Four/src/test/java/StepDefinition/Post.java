package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Post {
	
	@SuppressWarnings("unused")
	private static final String BASE_URL = "http://localhost:9010/home";
	
	@Given("I am on HomePage")
	public void i_am_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I add a shoe to the list")
	public void i_add_a_shoe_to_the_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a shoe will be added to the cart")
	public void a_shoe_will_be_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
