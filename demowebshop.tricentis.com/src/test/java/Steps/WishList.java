package Steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.WishListPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishList {
	
	Logger logger = LogManager.getLogger(WishList.class);

	private final WebDriver driver;
	private final WishListPage wishlist;

	public WishList() {
		driver = new ChromeDriver();
		wishlist = new WishListPage(driver);
		driver.manage().window().maximize();
	}

	@Given("User navigates to the URL demowebshop")
	public void user_navigates_to_the_url_demowebshop() {
		logger.info("User navigates to the URL");
		wishlist.navigateToURL("http://demowebshop.tricentis.com");
	}

	@When("User performs the login process with credentials")
	public void user_performs_the_login_process_with_credentials() {
		logger.info("User performs the login process");
		wishlist.clickLoginLink();
		wishlist.performLogin("iamalexanderwho@gmail.com", "12345678");
	}

	@Then("Validate the login is successful or not")
	public void validate_the_login_is_successful_or_not() {
		logger.info("Validate the login is successfulL");
		String e1 = driver.getTitle();
		String e2 = "Demo Web Shop";
		Assert.assertEquals(e2, e1);
	}

	@Given("the user is on the Demo Web Shop homepage")
	public void the_user_is_on_the_demo_web_shop_homepage() {
		logger.info("the user is on the Demo Web Shop homepage");

		wishlist.clickdigitalmenu();
		String e1 = driver.getTitle();
		String e2 = "Demo Web Shop. Digital downloads";
		Assert.assertEquals(e2, e1);
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string) {
		logger.info("the user clicks on {string}");
		wishlist.clickdigitalmenu();

	}

	@Then("the user adds products to the wishlist")
	public void the_user_adds_products_to_the_wishlist() {
		logger.info("the user adds products to the wishlist");
		wishlist.addProduct1();
		driver.navigate().back();

		wishlist.addProduct2();
		driver.navigate().back();

		wishlist.addProduct3();
		driver.navigate().back();

	}

	@Then("the user goes to the Wishlist")
	public void the_user_goes_to_the_wishlist() {
		logger.info("the user goes to the Wishlist");

		wishlist.viewProducts();
		String e1 = driver.getTitle();
		String e2 = "Demo Web Shop. Wishlist";
		Assert.assertEquals(e2, e1);

	}

	@Then("the user removes a product from the Wishlist")
	public void the_user_removes_a_product_from_the_wishlist() {
		logger.info("the user removes a product from the Wishlist");

		wishlist.viewProducts();
		;
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//tbody/tr[1]/td[1]/input[1]"));
		for (int i = 0; i < Math.min(2, checkboxes.size()); i++) {
			checkboxes.get(i).click();
		}
		wishlist.clickUpdateButton();
	}

	@Then("the Wishlist should be updated accordingly")
	public void the_wishlist_should_be_updated_accordingly() {
		logger.info("the Wishlist should be updated accordingly");
		WebElement table = driver.findElement(By.xpath("//table/tbody"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		if (rowCount == 1) {
			System.out.println(" Only one product in the wishlist");
		} else {
			System.out.println(" Multiple product in the wishlist");
		}
	}

	@After
	public void closebrowser() {
		driver.close();
	}

}
