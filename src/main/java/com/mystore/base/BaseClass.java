package com.mystore.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static String screenshotsSubFolderName;
	
	
	@BeforeSuite	
	public static void loadConfig() throws IOException {
			
	extent = new ExtentReports();
	File file = new File("index.html");
	spark = new ExtentSparkReporter(file);//html file will be generated
	spark.loadXMLConfig(new File("resources/extent-config.xml"));
	extent.attachReporter(spark);
	
	extent.setSystemInfo("OS", System.getProperty("os.name"));
	extent.setSystemInfo("Java", System.getProperty("java.version"));
	extent.setSystemInfo("ProjectName", "MyStoreProject");
	extent.setSystemInfo("Tester", "Bukky");
	extent.setSystemInfo("Browser", "Chrome");
	
	
	try {
		prop= new Properties();
		System.out.println("super constructor invoked");
		FileInputStream ip= new FileInputStream("./src/test/resources/Configuration/config.properties");
		prop.load(ip);
		System.out.println("driver:"+driver);
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
			
	}	
	
	
	/*@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	
	public void loadConfig() {
		
		try {
		prop= new Properties();
		System.out.println("super constructor invoked");
		FileInputStream ip= new FileInputStream("./src/test/resources/Configuration/config.properties");
		prop.load(ip);
		System.out.println("driver:"+driver);
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}*/
	
public void captureScreenshot(String fileName) {
		
		if(screenshotsSubFolderName==null) {
		
		 LocalDateTime myDateObj = LocalDateTime.now();
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
         screenshotsSubFolderName = myDateObj.format(myFormatObj);
		  
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" +screenshotsSubFolderName+"/"+fileName);
		//File destFile = new File("./Screenshots/" +fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
		
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void launchApp(String browserName) throws InterruptedException {
	
	   logger = LogManager.getLogger(BaseClass.class);
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
		}
			driver.manage().window().maximize();
			Thread.sleep(5000);
			driver.get(prop.getProperty("url"));
	 }
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})

	public void closeDown() {
		driver.quit();
		
	}
	
	@AfterSuite
	public void endTest() throws IOException {
		
		extent.flush();//unless you call this method, your report will not be written with logs
		Desktop.getDesktop().browse(new File("index.html").toURI());//open the file in the desktop default browse
		

}
	 
	 

}
