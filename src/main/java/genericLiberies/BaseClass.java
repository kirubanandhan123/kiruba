package genericLiberies;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.CoreJavaForSeleniumPage;
import pompages.HomePages;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;
import pompages.ContactUsPage;
import pompages.CoreJavaVedioPage;
import pompages.SeleniumTrainingPage;

public class BaseClass {
	protected PropertiesFileUtlity property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePages home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected ContactUsPage contact;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected SeleniumTrainingPage selenium;
	protected CoreJavaVedioPage javaVideo;
	protected long time;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	       public void classConfiguration()
	       {
		     property= new PropertiesFileUtlity();
		     excel= new ExcelUtility();
			 web=new WebDriverUtility();
		
		    
		     property.propertyFileInitilization(IConstantPath.PROPERTIES_FILE_PATH);
		     excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		     
	       }

	@BeforeMethod
	public void methodConfiguration() {
		time = Long.parseLong(property.fetchProperties("timeouts"));
		driver = web.openApplication(property.fetchProperties("browsers"), property.fetchProperties("url"), time);
		home=new HomePages(driver);
		skillraryDemo = new SkillraryDemoAppPage(driver);
		selenium= new SeleniumTrainingPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		javaVideo= new CoreJavaVedioPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
	}

	@AfterMethod
	    public void methodTearDown()
	    {
		   web.quitBrowser();
	    }
	@AfterClass
	     public void classTearDown()
	     {
		   excel.CloseExcel();
	     }
       	
	// @AfterTest
	// @AfterSuite
}


	
