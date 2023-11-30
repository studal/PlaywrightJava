package FactorySetting;

import org.apache.commons.io.FileUtils;
import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

public class BrowserFactory {

    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }
    public static Browser getBrowser() {
        return tlBrowser.get();
    }
    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }
    public static Page getPage() {
        return tlPage.get();
    }

    public Page launchBrowser() {
        Properties propFile = getPropertyFile();
        tlPlaywright.set(Playwright.create());
        String browserName = propFile.getProperty("Browser");
        System.out.println("browser name is :" + browserName);

        switch (browserName.toLowerCase()) {
            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless")))));
                tlBrowserContext.set(getBrowser().newContext());
                break;
            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless")))));
                tlBrowserContext.set(getBrowser().newContext());
                break;
            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless")))));
                tlBrowserContext.set(getBrowser().newContext());
                break;
            case "chrome":
                BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
                lp.setHeadless(Boolean.parseBoolean(propFile.getProperty("Headless")));
                lp.setChannel("chrome");
                List<String> ls = new ArrayList<String>();
                ls.add("--start-maximized");  // only works with chromium based, rest browser have to use .setViewportSize
                lp.setArgs(ls);
                tlBrowser.set(getPlaywright().chromium().launch(lp));
                tlBrowserContext.set(getBrowser().newContext((new Browser.NewContextOptions()
                        .setViewportSize(null)
                        .setRecordVideoDir(Paths.get("recording/"))
                        .setRecordVideoSize(1024, 720))));
                break;
            default:
                System.out.println("please pass a correct browser name......");
                break;
        }
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(propFile.getProperty("URL"));
        return getPage();
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

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);
        return base64Path;
    }

    public void emptyRecordingAndScreenshotDirectory() {
        String recDirectoryPath = System.getProperty("user.dir") + "/recording";
        String ssDirectoryPath = System.getProperty("user.dir") + "/screenshot";
        File recDirectory = new File(recDirectoryPath);
        File ssDirectory = new File(ssDirectoryPath);
        try {
            FileUtils.cleanDirectory(recDirectory);
            FileUtils.cleanDirectory(ssDirectory);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void createRecordingAndScreenshotDirectory() {
        String recDirectoryPath = System.getProperty("user.dir") + "/recording";
        String ssDirectoryPath = System.getProperty("user.dir") + "/screenshot";
        File recDirectory = new File(recDirectoryPath);
        File ssDirectory = new File(ssDirectoryPath);
        try {
            FileUtils.createParentDirectories(recDirectory);
            FileUtils.createParentDirectories(ssDirectory);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}