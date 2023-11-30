package Pages;

import com.microsoft.playwright.Page;

public class CheckoutCompletePage {

    Page page;
    public CheckoutCompletePage(Page page){
        this.page = page;
    }

    public String getCompleteOrderMessage(){
        return page.textContent("//h2");
    }

}
