package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutOverviewPage {

    public static Logger Log = LogManager.getLogger(CheckoutOverviewPage.class);
    Page page;
    public CheckoutOverviewPage(Page page){
        this.page = page;
    }

    private static String finishButtonLocator = "//button[@name='finish']";

    public void clickFinishButton(){
        page.click(finishButtonLocator);
        Log.info("Clicked on Finish button");
    }

}
