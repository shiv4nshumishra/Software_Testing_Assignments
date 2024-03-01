package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerClick;

	@FindBy(id = "gender-female")
	private WebElement genderClick;

	@FindBy(id = "FirstName")
	private WebElement firstNameClick;

	@FindBy(id = "LastName")
	private WebElement lastNameClick;

	@FindBy(id = "Email")
	private WebElement emailClick;

	@FindBy(id = "Password")
	private WebElement passwordClick;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordClick;

	

	@FindBy(id = "register-button")
	private WebElement registerButtonClick;
	
	@FindBy(xpath = "//span[@data-valmsg-for = 'FirstName']")
	public WebElement firstnameerror;
	
	@FindBy(xpath = "//span[@data-valmsg-for = 'LastName']")
	public WebElement lastnameerror;
	
	
	@FindBy(xpath = "//span[@data-valmsg-for = 'Email']")
	private WebElement emailerror;
	
	@FindBy(xpath = "//span[@data-valmsg-for = 'Password']")
	public WebElement PasswordError;
	
	@FindBy(xpath = "//span[@data-valmsg-for = 'ConfirmPassword']")
	public WebElement confirmPasswordError;

	/*
	 * @FindBy(xpath = "(//div[@class = 'validation-summary-errors'])/ul/li") public
	 * WebElement mailerr;
	 */
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickRegister() {
		registerClick.click();
	}

	public void clickGender() {
		genderClick.click();
	}

	public void enterFirstName(String fname) {
		firstNameClick.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastNameClick.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailClick.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordClick.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordClick.sendKeys(confirmPassword);
	}

	public void clickRegisterButton() {
		registerButtonClick.click();

	}

	/*
	 * public String getmessage(WebElement element) { return element.getText();
	 */
//	}
	public String firstnameRequired() {
		return firstnameerror.getText();
		}
	public String lastnameRequired() {
		return lastnameerror.getText();
		}
	
	public String emailRequired() {
		return emailerror.getText();
		}
	public String passwordRequired() {
		return PasswordError.getText();
		}
	public String confirmpasswordRequired() {
		return confirmPasswordError.getText();
		}

}
