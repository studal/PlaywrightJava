package Pages;

import com.microsoft.playwright.Page;

public class YourCartPage {

    static Page page;
    public YourCartPage(Page page){
        this.page = page;
    }

    private static String checkoutButtonLocator = "//button[@name='checkout']";

    public void clickCheckoutButton(){
        page.click(checkoutButtonLocator);
    }
}
