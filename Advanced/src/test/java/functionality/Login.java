package functionality;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import objectrepository.Elements;

public class Login {
	
	@Test
	public void actions1() throws InterruptedException, IOException, AWTException {
		
		WebDriver d1;
		
		FileInputStream fi=new FileInputStream("src\\test\\java\\sample\\Config.properties");
		
		Properties prop=new Properties();
		
		prop.load(fi);
		
		String browser_name=prop.getProperty("browser");
		
		String driver=prop.getProperty("path");
		
		if(browser_name.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",driver);
		d1=new ChromeDriver();
		
		}
		
		else if (browser_name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driver);
		 d1=new FirefoxDriver();
		}
		
		else {
			System.setProperty("webdriver.ie.driver",driver);
		d1=new InternetExplorerDriver();
		}
	
		
		d1.get("https://ksrtc.in/oprs-web/login/show.do");
		
		d1.manage().window().maximize();
		
		
		PageFactory.initElements(d1,Elements.class);
		
		Elements.username.sendKeys("Karthika");
		Elements.password.sendKeys("hcl");
		Elements.loginbutton.click();
		
		
		Dimension dim=new Dimension(250,350);
		
		d1.manage().window().setSize(dim);
		
 
}
}