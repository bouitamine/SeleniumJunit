package training;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.annotation.AnnotationList.Empty;

public class googleSearchTest {

	private WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Amine Bouita");
		searchbox.submit();

		// Implicit Wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Explicit Wait
//		WebDriverWait ewait = new WebDriverWait(driver, 10);
//		ewait.until(ExpectedConditions.titleContains("Amine Bouita"));
		
		//Fkuent Wait

		assertEquals("Amine Bouita - Buscar con Google", driver.getTitle());

		// ExplicitWait
		
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver).
				withTimeout(10, TimeUnit.SECONDS).
				pollingEvery(2, TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
	}

	@After
	public void tearDown() {

		driver.quit();
	}

}
