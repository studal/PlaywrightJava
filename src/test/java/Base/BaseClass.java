package Base;

import FactorySetting.BrowserFactory;
import Manager.PageManager;
import com.microsoft.playwright.Page;
import org.testng.annotations.*;


public class BaseClass {

     public BrowserFactory browserFactory = new BrowserFactory();

     protected PageManager launchBrowserAndApp(){
         Page page = browserFactory.launchBrowser();
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
    }

}
