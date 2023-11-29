package Base;

import FactorySetting.BrowserFactory;
import Manager.PageManager;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseClass {

    BrowserFactory browserFactory = new BrowserFactory();
    static Page page;

    @BeforeSuite
    public void clearRecordings(){
        browserFactory.deleteDirectory();
    }

    @BeforeTest
    public void browserInit(){
       Page page = browserFactory.launchBrowser();
       new PageManager(page);
    }

    @AfterTest
    public void closeBrowser(){
        browserFactory.closePage();
        browserFactory.closeBrowsercontext();

    }

}
