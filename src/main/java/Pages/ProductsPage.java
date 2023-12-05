package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductsPage {

    public static Logger Log = LogManager.getLogger(ProductsPage.class);

    Page page;
    public ProductsPage(Page page){
        this.page = page;
    }

    private static String pageTitleLocator = "//span[@class='title']";
    private static String itemToBeAddedToCartLocator = "//div[@class='inventory_item_name ' " +
            "and text()='"+ "%s" + "']/../../following-sibling::div//button";
    private static String topRightCartLocator = "//span[@class='shopping_cart_badge']";



    public String getPageTitle(){
        Log.info("Page title is : "+page.textContent(pageTitleLocator));
        return page.textContent(pageTitleLocator);
    }

    public void addItemToCart(String itemName){
        page.click(String.format(itemToBeAddedToCartLocator, itemName));
        Log.info(itemName+" added to cart");
    }

    public String getItemsAddedToCart(){
        return page.textContent(topRightCartLocator);
    }

    public void goToCart(){
        page.click(topRightCartLocator);
        Log.info("Clicked on Cart icon");
    }


}
