package Pages;

import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {
    static Page page;
    public CheckoutOverviewPage(Page page){
        this.page = page;
    }

    private static String finishButtonLocator = "//button[@name='finish']";

    public void clickFinishButton(){
        page.click(finishButtonLocator);
    }

}
