package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutCompletePage {

    public static Logger Log = LogManager.getLogger(CheckoutCompletePage.class);
    Page page;
    public CheckoutCompletePage(Page page){
        this.page = page;
    }

    public String getCompleteOrderMessage(){
        return page.textContent("//h2");
    }

}
