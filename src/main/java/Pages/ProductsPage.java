package Pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    static Page page;

    private static String pageTitleLocator = "//span[@class='title']";

    public ProductsPage(Page page){
        this.page = page;
    }

    public String getPageTitle(){
        return page.textContent(pageTitleLocator);
    }

}
