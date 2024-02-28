package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtoCart {
	String siteUrl = "https://demowebshop.tricentis.com/";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();
		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterMethod
	public void cleanUp() {
		/*if(ITestResult.FAILURE==result.getStatus()) {
			//File fileName = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(fileName, new File("D:\\GIT\\A.MLA.T\\SeleniumS2\\S2\\Screenshots\\TestCaseFailed.png"));
		}*/
		// driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
		 driver.close(); // the close() closes only the current window on which
	}
	
	@Test
	public void verifyAddToCartButton() {
	  // Launch the website
	  //driver.get("https://demowebshop.tricentis.com");
	  // Click on the book category
	  driver.findElement(By.linkText("Books")).click();
	  // Get all the books displayed on the page
	  java.util.List<WebElement> books = driver.findElements(By.className("product-item"));
	  // Loop through each book and check if it has the Add to cart button
	  for (WebElement book : books) {
	    // Find the Add to cart button for each book
	    WebElement addToCartButton = book.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button"));
	    // Assert that the button is displayed and enabled
	    Assert.assertTrue(addToCartButton.isDisplayed() && addToCartButton.isEnabled());
	  }
	}
	/*
	@Test
	public void addThirdBookToCart() {
	  // Launch the website
	  //driver.get("https://demowebshop.tricentis.com");
	  // Click on the book category
	  driver.findElement(By.linkText("Books")).click();
	  // Get the third book displayed on the page
	  WebElement thirdBook = driver.findElements(By.className("product-item")).get(2);
	  // Get the title of the third book
	  String bookTitle = thirdBook.findElement(By.className("product-title")).getText();
	  // Click on the Add to cart button for the third book
	  thirdBook.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();
	  // Wait for the notification bar to appear
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
	  // Get the notification message
	  String message = driver.findElement(By.className("content")).getText();
	  // Assert that the message contains the book title and the success message
	  Assert.assertTrue(message.contains(bookTitle) && message.contains("The product has been added to your shopping cart"));
	  // Close the notification bar
	  driver.findElement(By.className("close")).click();
	  // Click on the shopping cart link
	  driver.findElement(By.className("cart-label")).click();
	  // Get all the items in the cart
	  java.util.List<WebElement> items = driver.findElements(By.className("cart-item-row"));
	  // Loop through each item and check if it matches the book title
	  boolean found = false;
	  for (WebElement item : items) {
	    // Get the item name
	    String itemName = item.findElement(By.className("product-name")).getText();
	    // Compare the item name with the book title
	    if (itemName.equals(bookTitle)) {
	      // Set the found flag to true and break the loop
	      found = true;
	      break;
	    }
	  }
	  // Assert that the book is found in the cart
	  Assert.assertTrue(found);
	}
*/

	/*
	@Test
	public void completeCheckoutProcess() {
	  // Launch the website
	  driver.get("https://demowebshop.tricentis.com");
	  // Click on the book category
	  driver.findElement(By.linkText("Books")).click();
	  // Get the third book displayed on the page
	  WebElement thirdBook = driver.findElements(By.className("product-item")).get(2);
	  // Get the title of the third book
	  String bookTitle = thirdBook.findElement(By.className("product-title")).getText();
	  // Click on the Add to cart button for the third book
	  thirdBook.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();
	  // Wait for the notification bar to appear
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
	  // Close the notification bar
	  driver.findElement(By.className("close")).click();
	  // Click on the shopping cart link
	  driver.findElement(By.className("cart-label")).click();
	  // Click on the checkout button
	  driver.findElement(By.id("checkout")).click();
	  // Login as a guest
	  driver.findElement(By.id("checkout-as-guest")).click();
	  // Fill the billing address details
	  driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("John");
	  driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");
	  driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("johndoe@example.com");
	  driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United States");
	  driver.findElement(By.id("BillingNewAddress_City")).sendKeys("New York");
	  driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Main Street");
	  driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("10001");
	  driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button")).click();
	  // Wait for the shipping address page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping-address-select")));
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-1.shipping-address-next-step-button")).click();
	  // Wait for the shipping method page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shippingoption_1")));
	  // Select the ground shipping option
	  driver.findElement(By.id("shippingoption_1")).click();
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-1.shipping-method-next-step-button")).click();
	  // Wait for the payment method page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentmethod_1")));
	  // Select the credit card option
	  driver.findElement(By.id("paymentmethod_1")).click();
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button")).click();
	  // Wait for the payment information page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCardType")));
	  // Fill the credit card details
	  driver.findElement(By.id("CreditCardType")).sendKeys("Visa");
	  driver.findElement(By.id("CardholderName")).sendKeys("John Doe");
	  driver.findElement(By.id("CardNumber")).sendKeys("4111111111111111");
	  driver.findElement(By.id("ExpireMonth")).sendKeys("01");
	  driver.findElement(By.id("ExpireYear")).sendKeys("2025");
	  driver.findElement(By.id("CardCode")).sendKeys("123");
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button")).click();
	  // Wait for the confirm order page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.button-1.confirm-order-next-step-button")));
	  // Click on the confirm button
	  driver.findElement(By.cssSelector("input.button-1.confirm-order-next-step-button")).click();
	  // Wait for the order completed page to load
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("order-completed")));
	  // Get the order number
	  String orderNumber = driver.findElement(By.className("order-number")).getText();
	  // Assert that the order number is not null or empty
	  Assert.assertNotNull(orderNumber);
	  Assert.assertFalse(orderNumber.isEmpty());
	  // Click on the continue button
	  driver.findElement(By.cssSelector("input.button-2.order-completed-continue-button")).click();
	  // Click on the my account link
	  driver.findElement(By.className("account")).click();
	  // Click on the orders link
	  driver.findElement(By.linkText("Orders")).click();
	  // Get all the orders displayed on the page
	  List<WebElement> orders = driver.findElements(By.className("order-item"));
	  // Loop through each order and check if it matches the order number
	  boolean found = false;
	  for (WebElement order : orders) {
	    // Get the order number for each order
	    String orderNumberFromList = order.findElement(By.className("order-number")).getText();
	    // Compare the order number with the order number from the confirmation page
	    if (orderNumberFromList.equals(orderNumber)) {
	      // Set the found flag to true and break the loop
	      found = true;
	      break;
	    }
	  }
	  // Assert that the order is found in the list
	  Assert.assertTrue(found);
	}
*/
	
	/*
	@Test
	public void deleteTwoProductsFromCart() {
	  // Launch the website
	  driver.get("https://demowebshop.tricentis.com");
	  // Click on the book category
	  driver.findElement(By.linkText("Books")).click();
	  // Get the first three books displayed on the page
	  java.util.List<WebElement> books = driver.findElements(By.className("product-item")).subList(0, 3);
	  // Loop through each book and click on the Add to cart button
	  for (WebElement book : books) {
	    book.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();
	    // Wait for the notification bar to
	*/

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addtocart {

	private final WebDriver driver;

	@FindBy(css = "a.ico-login")
	private WebElement loginLink;

	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;

	@FindBy(css = "input[value='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[contains(@href, '/books')][1]")
	private WebElement bookmenu;

	@FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
	private WebElement validatesbutton;

	@FindBy(xpath = "//a[normalize-space()='Copy of Computing and Internet EX']")
	private WebElement Iconlist2;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Fiction']")
	private WebElement Iconlist3;

	@FindBy(xpath = "//a[normalize-space()='Fiction EX']")
	private WebElement Iconlist4;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Health Book']")
	private WebElement Iconlist5;

	@FindBy(xpath = "//a[normalize-space()='Science']")
	private WebElement Iconlist6;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement Shoppingcart;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement Shopingproduct;

	public addtocart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public void validatebutton() {
		validatesbutton.click();
	}

	public void Iconlists1() {
		driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")).click();;
	}

	public void Iconlists2() {
		Iconlist2.click();
	}

	public void Iconlists3() {
		Iconlist3.click();
	}

	public void Iconlists4() {
		Iconlist4.click();
	}

	public void Iconlists5() {
		Iconlist5.click();
	}

	public void Iconlists6() {
		Iconlist6.click();
	}

	public void clickIconlists(int productNumber) {
		switch (productNumber) {
		case 1:
			Iconlist1.click();
			break;
		case 2:
			Iconlist2.click();
			break;
		case 3:
			Iconlist3.click();
			break;
		case 4:
			Iconlist4.click();
			break;
		case 5:
			Iconlist5.click();
			break;
		case 6:
			Iconlist6.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid product number: " + productNumber);
		}
	}

	public void shoppingcart() {
		Shoppingcart.click();
	}

	public void shoppingpro() {
		Shopingproduct.click();
	}

	public void performLogin(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	public void clickbookmenu() {
		bookmenu.click();
	}

}

