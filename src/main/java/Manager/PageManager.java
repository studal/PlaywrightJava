package Manager;

import Pages.*;
import com.microsoft.playwright.Page;

public class PageManager {

    Page page ;

    public PageManager(Page page){
        this.page = page;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(page);
    }
    public ProductsPage getProductsPage(){
        return new ProductsPage(page);
    }
    public YourCartPage getYourCartPage(){
        return new YourCartPage(page);
    }
    public CheckoutInformationPage getCheckoutInformationPage(){
        return new CheckoutInformationPage(page);
    }

    public CheckoutOverviewPage getCheckoutOverviewPage(){
        return new CheckoutOverviewPage(page);
    }

    public CheckoutCompletePage getCheckoutCompletePage(){
        return new CheckoutCompletePage(page);
    }
}
