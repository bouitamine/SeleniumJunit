package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage extends Base {

	public SingInPage(WebDriver drive) {
		super(drive);
		// TODO Auto-generated constructor stub
	}

	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");

	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	public void signIn() {
		if (isDisplayed(userLocator)) {
			type("bouitamine", userLocator);
			type("Password11", passLocator);
			click(signInBtnLocator);
		} else {
			System.out.print("username textbox was not found");
		}

		
	}

	public Boolean isHomePage() {
		return isDisplayed(homePageLocator);

	}

}
