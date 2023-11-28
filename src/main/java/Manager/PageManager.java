package Manager;

import Pages.LoginPage;
import Pages.ProductsPage;
import com.microsoft.playwright.Page;

public class PageManager {

    static Page page;

    public PageManager(){
    }

    public PageManager(Page page){
        this.page = page;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(page);
    }
    public ProductsPage getProductsPage(){
        return new ProductsPage(page);
    }

}
