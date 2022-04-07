package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
	
	
	
	@FindBy(id="username")
	public static WebElement username;
	
	@FindBy(name="password")
	public static WebElement password;
	
	@FindBy(id="submitBtn")
	public static WebElement loginbutton;
	
	
	
	/*public static WebElement username(WebDriver d1) {
		return d1.findElement(By.id("userName"));
	}
	
	
	public static WebElement password(WebDriver d1) {
		return d1.findElement(By.name("password"));
	}
	
	
	public static  WebElement loginbutton(WebDriver d1) {
	return d1.findElement(By.id("submitBtn"));	
		
	}*/
	

}
