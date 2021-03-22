package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.Destination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {

	WebDriver driver;
	String fileWithPath = System.getProperty("user.dir")+"\\src\\main\\java\\TakenScreenshots\\";
	
	
	
	public Screenshot(WebDriver driver) {
		this.driver=driver;
	}
	
	public String takeSnapShot() throws IOException {
		
	TakesScreenshot scrShot=(TakesScreenshot) driver;	
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	String TimeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	File DestFile=new File(fileWithPath+"Screen"+" "+TimeStamp+".png");
	String Desitination = (fileWithPath+"Screen"+" "+TimeStamp+".png");
	
	FileUtils.copyFile(SrcFile,DestFile);
	
	return Desitination;
	}
}
