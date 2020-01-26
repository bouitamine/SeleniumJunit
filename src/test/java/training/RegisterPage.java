package training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base {

	public RegisterPage(WebDriver drive) {
		super(drive);
		// TODO Auto-generated constructor stub
	}

	By registerLinkLocator = By.linkText("REGISTER");
	By regiterPageLocator = By.xpath("//img[@src=\"/images/masts/mast_register.gif\"]");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("register");
	By registerMessage = By.tagName("font");
	
	public void registerUser() throws InterruptedException {
		
		click(registerLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(regiterPageLocator)) {
			type("bouitamine", usernameLocator);
			type("Password11", passwordLocator);
			type("Password11", confirmPasswordLocator);
			click(registerBtnLocator);
		} else {
			System.out.print("Register page not found");
		}
	}
	
	
	public String registerMessage() {
		
		List<WebElement> fonts = findElements(registerMessage);	
		return getText(fonts.get(5));
		
	}
	
}
