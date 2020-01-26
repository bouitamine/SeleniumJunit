package training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_automatedTest {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By regiterPageLocator = By.xpath("//img[@src=\"/images/masts/mast_register.gif\"]");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("register");

	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");

	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(regiterPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("bouitamine");
			driver.findElement(passwordLocator).sendKeys("Password11");
			driver.findElement(confirmPasswordLocator).sendKeys("Password11");

			driver.findElement(registerBtnLocator).click();

		} else {
			System.out.print("Register page not found");
		}

		List<WebElement> font = driver.findElements(By.tagName("font"));

		assertEquals("Note: Your user name is bouitamine.", font.get(5).getText());

	}

	@Test
	public void signIn() throws InterruptedException {
		if (driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("bouitamine");
			driver.findElement(passLocator).sendKeys("Password11");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(homePageLocator).isDisplayed());

		} else {
			System.out.print("No se ha logeado correctamente");
		}
	}
}
