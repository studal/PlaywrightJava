import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void testMethod(){

        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions().setChannel("chrome"));
//        To run specifically chrome
//        Browser browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
//          Or
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        lp.setChannel("chrome");
        List<String> ls = new ArrayList<String>();
        ls.add("--start-maximized");  // only works with chromium based, rest browser have to use .setViewportSize
        ls.add("");
        lp.setArgs(ls);
        Browser browser = playwright.chromium().launch(lp);
//        browser.newPage(); // This can also work
        BrowserContext bc = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null)); //One browser context does not share cookies/cache with other browser context
//                .setRecordVideoDir(Paths.get("recording/"))
//                .setRecordVideoSize(1024,720));

        Page page = bc.newPage();

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = (int)screensize.getWidth();
        double height = (int)screensize.getHeight();

//      page.pause();

        /*
        Locators
        */
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.locator("//input[@name='username']").fill("Admin");
        page.locator("//input[@name='password']").fill("admin123");
        page.locator("//button[@type='submit']").click();
        System.out.println(page.title());


//        If there are more locators  instead of get(i) we have nth(i) here
//        Locator locator = page.locator("//div[@class='orangehrm-buzz-widget-header']");
//        locator.first().click();
//        locator.last().click();
//        locator.nth(2).click();

        // Gettext
        page.locator("//div[@class='orangehrm-buzz-widget-header']/following-sibling::p").first().textContent();
        //Logger

//        page.locator("//div[@class='orangehrm-buzz-widget-header-text']/p[1]").textContent() // will fail
//        Because it resolves to 5 elements so for that use below

    // Get all texts as string list
        List<String> stringList = page.locator("//div[@class='orangehrm-buzz-widget-header-text']/p[1]").allTextContents();
        //Logger
        stringList.forEach(ele -> System.out.println(ele));

//        SELECTORS
        /*
        1. Selecting using text
        */
        page.locator("text='Admin'").click();
//    OR  page.locator("text='Admin'").first().click(); // if there are more than 1
//        page.locator("text='Admin'").nth(2).click();
//        page.locator("span:text('Admin')").click();
//        page.locator("'Admin'").first().click();
//        page.locator("span:has-text('Admin')").click();
//        page.locator("div.well span:has-text('Admin')").click(); //you can mention parent class as well

        /*
        2. Frames
        */
        page.navigate("http://londonfreelance.org/courses/frames/index.html");
        String header = page.frameLocator ("frame[name='main']").locator("h2").textContent();
        System.out.println(header);

        /*
        iFrame
        */
        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration");
//        page.navigate("https://demoqa.com/frames");
//        page.frames(); //Gives you a list of all the frames available in page
        page.locator("img [title='vehicle-registration-forms-and-templates']").click();
        FrameLocator fl = page.frameLocator("//iframe|[contains (@id, 'frame-one')]");
        fl.locator("#RESULT_TextField-8").fill("Naveen Automation");

        /*
        3. ShadowDom
        */
        page.navigate("https://books-pwakit.appspot.com/");
        page. locator ("book-app [apptitle='BOOKS'] #input").fill("Testing Books");
//                      ( This part is css address of showroot) (Second half is of desired element)

//        What if shadow root is inside of an iFrame
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.frameLocator("#pact"). locator ("div#snacktime #tea").fill("xyz");
//                                          ( This part is css address of showroot) (Second half is of desired element)

//        This is how selenium use to do it.
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement input = (WebElement) (js.executeScript(
//                "return document.querySelector(\"body> book-app\")"
//                        + ".shadowRoot"
//                ".querySelector(\" #input\")"));
//        input.sendKeys("I am selenium");

        /*
        4. Selecting Visible Elements
        */
        page.navigate("https://www.amazon.com/");
        List<String> linksText = page.locator("a:visible").allInnerTexts(); // adding visible displays the
                                                                // buttons or tags that are visible on page
        for(int i=0; i<linksText.size(); i++) {
            System.out.println(linksText.get(i));
        }
        int imagesCount = page.locator ("xpath=//img >> visible=true").count();
        System.out.println(imagesCount);

        /*
        5.  Playwright inspector
        */
//        npx playwright install
//        npx playwright codegen wikipedia.org
//        OR   page.pause(); to open inspector as well.

        /*
        6. Chrome devtools  // Because playwright gives addition selectors apart from xpath and css which you cannot
                                find in elements tab, these will only show in inspect tab.
               Inspect browser window that opened with CLI, only that browser will recognize following commands
        */
//        playwright.$$("selector") // gives multiple results from DOM  // see 1st point what is selector
//        playwright.$("selector") // gives single line result from DOM
//        playwright.inspect("selector") // will take you directly to element in DOM
//
//        > playwright.$$("a: has-text('Amazon')")  this command gave you 26 results
//                <• (26) [a.nav-link.nav-item, a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a,
//                a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.nav_a
//        a.nav_a, a.nav_a, a.nav_a, a.nav_a, a.hmenu-item, a. hmenu-item, a. hmenu-item,
//                a.hmenu-item]

        /*
        7. HAS     -  selecting elements that contains other elements.
        */
//        playwright.$("select#Form_submitForm_Country:has (option [value='India'])) "
        Locator footerList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
        footerList.allInnerTexts().forEach(e ->System.out.println(e));

        /*
        8. selecting elements matching one of the conditions (provide multiple values comma separated)
        */
        page.locator("span: has-text('SignIn'),"
                        + "span: has-text('LogIn'),"
                        + "span: has-text('Login'),"
                        + "I span: has-text('Signin')").click();

//        playwright.$$("span: has-text('Store'), span: has-text('signin'), a:has-text('EXPLORE COURSES')")

        /*
        9. Relative Locators from selenium 4
        */
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator("input[type='checkbox'] : left-of(: text ('Joe. Root'))").first().click();

        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
        page.locator("input: below (label: text('Full Name'))").first().fill("Sandeep");
        page.locator("input: below (label:text('Email'))").first().fill("sandy@gmail.com");
        page.locator("input:below (label: text('Phone Number'))").first().fill("88778877");

//        Layout pseudo-classes use bounding client rect to compute distance and relative position of the elements.
//          :right-of(div > button) -
//          :left-of(div > button) -
//          :above(div > button) -
//          :below(div > button) -
//          :near(div > button, 120) - you can also provide, for how many pixels to look for.

        /*
       10. Nth element selector
        */
//        playwright.$$("div. footer-links li a >> nth=0")
//                      {   CSS part            }  {  nth  }


        /*
       11. React locators  //Experimental feature
        */
        page.navigate("https://www.netflix.com/ae-en/");
        Locator email = page. locator("_react=p[name='email'] >> input").first();
        email.click();
        email.fill("sandy@gmail.com" );

        /*
       12.  xPath
        */

        page. locator ("xpath=//input(@id='twotabsearchtextbox']").fill("Macbook pro");
//        // No need to mention "xpath" keyword
        page. locator ("//input(@id='twotabsearchtextbox']").fill("Macbook pro");

        /*
       13. Automatic login
        */
        page.navigate("http://automationpractice.pl/");
        page. click("a:text( 'Sign in')");
        page. fill("#email", "sandy@gmail.com");
        page. fill( "#passwd", "sandy12345");
        page. click("#SubmitLogin");
        bc.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
        // Perform these steps to create .json at root level.
        // Next time you open the app make sure the crowsercontext uses saved configuration with-
        //                                              - setStorageStatePath method

        Playwright playwright2 = Playwright.create();
        BrowserType.LaunchOptions lp2 = new BrowserType.LaunchOptions();
        lp2.setHeadless(false);
        lp2.setChannel("chrome");
        List<String> ls2 = new ArrayList<String>();
        ls2.add("--start-maximized");  // only works with chromoum based, rest browser have to use .setViewportSize
        ls2.add("");
        lp.setArgs(ls);
        Browser browser2 = playwright.chromium().launch(lp);
//        browser.newPage(); // This can also work
        BrowserContext bc2 = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null).setStorageStatePath(Paths.get("applogin.json")));  //One browser context does not share cookies/cache with other browser context
        Page page2 = bc.newPage();
        page.navigate("http://automationpractice.pl/");

        /*
        14. Popups and alerts
        */
        // By default it will automatically close the popups and you will not even see them.
        // If you want to handle alerts on your own, then use onDialog method when launching browser.
        // Mention the desired action, before the alert could popup.

        Page page3 = bc.newPage();
        page3.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page3.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept("Hi you know me");
//            dialog.dismiss();
        });
        page3.click("//button[text()='Click for JS Prompt']");

        /*
        15 file upload
        */
        //select one file:
        page.setInputFiles("input#filetoupload", Paths.get("applogin.json"));

        // Now to deselect the file
        page.setInputFiles("input#filetoupload", new Path[0]);

        // Upload multiple files
        page.setInputFiles("input#filetoupload", new Path[]{
                                                        Paths.get("applogin.json"),
                                                        Paths.get("applogin2.json")});

        /*
        16 Download a file
        */
        Download dnload = page.waitForDownload(() -> {
            page.click("a:text(chromedriver.zip)");
        });

        dnload.url(); //Returns download url
        dnload.page().title(); //Title of page
        dnload.path().toString(); // Default path of download
        dnload.saveAs(Paths.get("Desired-name.Zip")); //Download file to root of project with desired name
        dnload.saveAs(Paths.get("C:/folder/Desired-name.Zip")); //Download file to desired folder with desired name
        dnload.cancel(); // Cancel download
        dnload.failure(); //Returns download error if any
        dnload.suggestedFilename(); //Returns file name which was suggested originally by website.

        /*
        17 Swithing between Tabs
         */
        BrowserContext bx1 = browser.newContext();
        Page page1 = bx1.newPage();
        page1.navigate("https://opensource-demo.orangehrmlive.com/") ;

        //1. open a new tab.window/popup after clicking on Link on the parent page:
        Page popup = page1.waitForPopup(() -> {
                    page1.click("img [alOrangeHRM on twitter']");
                });
            popup.waitForLoadState();
        System.out.println("pop up window title:"  + popup.title());
        popup.close();
        System.out.println("parent up window title: " + page.title());
        page.close();

        // Note bx1.pages() will give list of all pages you have opened in the browser context.
        // From there you can use bx1.pages().get(1).bringToFront(); to start showing and interacting with your desired page
        // Or you can save the new tab to page object i.e Page p1 = bx1.pages().get(1);




        }
}



















