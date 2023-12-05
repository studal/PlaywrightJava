package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YourCartPage {

    public static Logger Log = LogManager.getLogger(YourCartPage.class);

    Page page;
    public YourCartPage(Page page){
        this.page = page;
    }

    private static String checkoutButtonLocator = "//button[@name='checkout']";

    public void clickCheckoutButton(){
        page.click(checkoutButtonLocator);
        Log.info("Clicked on Checkout button");
    }
}
