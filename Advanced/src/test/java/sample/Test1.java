package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Test1 {



	public class UploadDownload {
		WebDriver w;
		Robot r;
	  @Test
	  public void DownloadFile() throws IOException, AWTException, InterruptedException{
		  
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\skarthika\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		  ChromeOptions c = new ChromeOptions();
			Map<String, Object> p = new HashMap<String, Object>();
	        p.put("plugins.always_open_pdf_externally", true);
			c.setExperimentalOption("prefs", p);
			w = new ChromeDriver(c);
		  
			
			  w.get("http://leafground.com/pages/download.html");
			  w.manage().window().maximize();
			  
			  w.findElement(By.linkText("Download PDF")).click();
			  Thread.sleep(5000);
			  File f = new File("C:\\Users\\manjula_m\\Downloads");
			  File[] list_files = f.listFiles();
			  for (File f1 : list_files)
			  { 
				  System.out.println(f1.getName());
					
					  if(f1.getName().equalsIgnoreCase("testleaf.pdf")) {
					  System.out.println("file downloaded successfully"); break; }
					 
			  }
			w.close();  
	  }
		

	}



}
