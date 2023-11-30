package Pages;

import com.microsoft.playwright.Page;

public class ProductsPage {

    Page page;
    public ProductsPage(Page page){
        this.page = page;
    }

    private static String pageTitleLocator = "//span[@class='title']";
    private static String itemToBeAddedToCartLocator = "//div[@class='inventory_item_name ' " +
            "and text()='"+ "%s" + "']/../../following-sibling::div//button";
    private static String topRightCartLocator = "//span[@class='shopping_cart_badge']";



    public String getPageTitle(){
        return page.textContent(pageTitleLocator);
    }

    public void addItemToCart(String itemName){
        page.click(String.format(itemToBeAddedToCartLocator, itemName));
    }

    public String getItemsAddedToCart(){
        return page.textContent(topRightCartLocator);
    }

    public void goToCart(){
        page.click(topRightCartLocator);
    }


}
