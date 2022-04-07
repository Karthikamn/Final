package sample;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test2 {

	@Test(enabled=false)
	public void leaf() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		d1.get("http://www.leafground.com/");
		d1.findElement(By.linkText("Edit")).click();
		d1.findElement(By.id("email")).sendKeys("karthika@hcl.com");
		d1.findElement(By.cssSelector("input[value='Append ']")).sendKeys("S");
		d1.findElement(By.name("username")).sendKeys("HCL");
		d1.findElement(By.xpath("//input[@value='Clear me!!']")).sendKeys("Chennai");
		d1.findElement(By.xpath("//img[@src='../images/testleaf_logo.png']")).click();


	}


	@Test(enabled=false)
	public void leaf1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		d1.get("http://www.leafground.com/pages/Alert.html");
		d1.findElement(By.cssSelector("button[onclick='confirmPrompt()']")).click();
		// String msg1=d1.switchTo().alert().getText();
		// System.out.println(msg1);
		d1.switchTo().alert().sendKeys("HCL");
		d1.switchTo().alert().accept();


	}

	@Test(enabled=false)
	public void frames() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		d1.get("http://www.leafground.com/pages/frame.html");
		d1.switchTo().frame(0);
		d1.findElement(By.id("Click")).click();

		d1.switchTo().defaultContent();

		WebElement ele1=d1.findElement(By.xpath("//*[@src='page.html']"));
		d1.switchTo().frame(ele1);

		d1.switchTo().frame("frame2");

		d1.findElement(By.id("Click1")).click();

		d1.switchTo().parentFrame();

	}

	@Test(enabled=false)
	public void windows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		d1.get("http://www.leafground.com/pages/Window.html");
		System.out.println(d1.getTitle());
		d1.findElement(By.id("home")).click();

		Set<String> window_handle=d1.getWindowHandles();
		Iterator<String> iter= window_handle.iterator();

		String w1=iter.next();
		String w2=iter.next();

		d1.switchTo().window(w2);


		System.out.println(d1.getTitle());

		System.out.println(w1);
		System.out.println(w2);
	}


	@Test
	public void actions1() throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver d1=new ChromeDriver();
		
		d1.manage().window().maximize();
		
		d1.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_ya_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D486386870127%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D1819306130214511711%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062230%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2154373%26gclid%3DCj0KCQiAraSPBhDuARIsAM3Js4rbt-KZMGNYRvr98PNLO66dHA9pFpNCSYfSUlfj1JtREy9r4bCW5cgaAkjbEALw_wcB&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
		
		d1.findElement(By.id("ap_email")).sendKeys("Karthika");
		
		d1.findElement(By.id("continue")).click();
		
		File fi=new File("C:\\Users\\skarthika\\OneDrive - HCL Technologies Ltd\\Desktop\\reports\\cookies.data");
		
		try {
			
			fi.createNewFile();
			
			FileWriter fw=new FileWriter(fi);
			
			BufferedWriter bw=new BufferedWriter(fw);
			
			for(Cookie ck:d1.manage().getCookies()) {
				
				bw.write((ck.getName()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getValue()+";"+ck.getExpiry()+";"+ck.isSecure()));
				
				bw.newLine();
				
				
			}
			
			Cookie ck1=new Cookie("mycookie1","123456789");
			
			d1.manage().addCookie(ck1);
			
			d1.manage().deleteCookie(ck1);
			
			d1.manage().deleteCookieNamed("mycookie1");
			
			d1.manage().deleteAllCookies();
			
			d1.manage().getCookieNamed("cookie_name");

			
			
			bw.close();
			
			fw.close();
			
			
			
			
			
		}
		
		
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		
	
		
		
	}}
		
		
		
		
	
	
	
	

		

	