package Base;

import FactorySetting.BrowserFactory;
import Manager.PageManager;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


public class BaseClass{

    public static Logger Log = LogManager.getLogger(BaseClass.class);

     public BrowserFactory browserFactory = new BrowserFactory();

     protected PageManager launchBrowserAndApp(){
         Page page = browserFactory.launchBrowser();
         Log.info("Application is loaded");
         return new PageManager(page);
     }

    @BeforeSuite
    public void clearRecordingsAndScreenshots(){
        browserFactory.createRecordingAndScreenshotDirectory();
        browserFactory.emptyRecordingAndScreenshotDirectory();

    }


    @AfterMethod
    public void closeBrowser(){
        browserFactory.getBrowser().close();
        Log.info("Browser is closed");
    }

}
