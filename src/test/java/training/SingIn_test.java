package training;

import static org.junit.Assert.*;

import javax.management.loading.PrivateClassLoader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingIn_test {

	private WebDriver driver;
	private SingInPage singInPage;
	private String url = "http://newtours.demoaut.com/";

	@Before
	public void setUp() throws Exception {
		singInPage = new SingInPage(driver);
		driver = singInPage.chromeDriverConnection();
		singInPage.visit(url);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		singInPage.signIn();
		Thread.sleep(2000);
		assertTrue(singInPage.isHomePage());
	}

}
