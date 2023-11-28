package Base;

import FactorySetting.BrowserFactory;
import Manager.PageManager;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {

    BrowserFactory browserFactory = new BrowserFactory();
    static Page page;

    @BeforeTest
    public void browserInit(){
       browserFactory.deleteDirectory();
       Page page = browserFactory.launchBrowser();
       new PageManager(page);
    }

    @AfterTest
    public void closeBrowser(){
        browserFactory.closePage();
        browserFactory.closeBrowsercontext();

    }

}
