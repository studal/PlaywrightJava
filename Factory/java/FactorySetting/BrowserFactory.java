package FactorySetting;

import org.apache.commons.lang3.StringUtils;
import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrowserFactory {

    static Playwright playwright;
    static BrowserContext browserContext;
    static Page page;
    static Browser browser;


    public Page launchBrowser() {
        Properties propFile = getPropertyFile();
        playwright = Playwright.create();
        String browserName = propFile.getProperty("Browser");
        System.out.println("browser name is :" + browserName);

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless"))));
                browserContext = browser.newContext();
                page = browserContext.newPage();
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless"))));
                browserContext = browser.newContext();
                page = browserContext.newPage();
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless"))));
                browserContext = browser.newContext();
                page = browserContext.newPage();
                break;
            case "chrome":
                BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
                lp.setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless")));
                lp.setChannel("chrome");
                List<String> ls = new ArrayList<String>();
                ls.add("--start-maximized");  // only works with chromium based, rest browser have to use .setViewportSize
                lp.setArgs(ls);
                browser = playwright.chromium().launch(lp);
                browserContext = browser.newContext(new Browser.NewContextOptions()
                        .setViewportSize(null)
                        .setRecordVideoDir(Paths.get("recording/"))
                        .setRecordVideoSize(1024, 720));
                page = browserContext.newPage();
                break;
            default:
                System.out.println("please pass a correct browser name......");
                break;
        }
        page.navigate(propFile.getProperty("URL"));
        return page;

    }

    private Properties getPropertyFile() {
        try {
            String rootPath1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String rootPath = System.getProperty("user.dir") + "/src/main/resources/test.properties";

            Properties appProps = new Properties();
            appProps.load(new FileInputStream(rootPath));
            return appProps;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void closeBrowsercontext(){
        browserContext.close();
    }

    public void closePage(){
        page.close();
    }

    public void deleteDirectory(){
        String directoryPath = System.getProperty("user.dir") + "/recording/";
        File directory = new File(directoryPath);
        directory.delete();
    }
}