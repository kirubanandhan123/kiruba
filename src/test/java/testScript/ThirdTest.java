package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLiberies.BaseClass;

public class ThirdTest extends BaseClass {
	@Test
	public void thirdTest()
	{
		SoftAssert soft=new SoftAssert();
		home.searchFor("core java for selenium");
		soft.assertEquals(coreJava.getPageHeader(), "CORE JAVA FOR SELENIUM");
		
		coreJava.clickCoreJavaForSeleniumLink();
		soft.assertEquals(javaVideo.pageHeader(), "core java for selenium training ");
		
		//javaVideo.
		//web.switchToFrame();
		
		
		
		
	}
	

}
