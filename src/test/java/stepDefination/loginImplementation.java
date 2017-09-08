package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginImplementation {

	WebDriver driver;

	@Given("^open chrome driver$")
	public void open_chrome_driver() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/manojkumar/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Given("^navigate to correct url$")
	public void navigate_to_correct_url() throws Throwable {
		driver.get("http://moneybhai.moneycontrol.com/");
		String firsthandle = driver.getWindowHandle();
		driver.switchTo().window(firsthandle);
	}

	@Given("^provide valid credentials$")
	public void provide_valid_credentials() throws Throwable {
		driver.findElement(By.partialLinkText("Login")).click();
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.xpath("//form[@id='login_form']/div[1]")).sendKeys("manoj300686@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("Killme@135");
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
    
	}

}
