import Base.BaseClass;
import Manager.PageManager;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends BaseClass {

    @Test
    public void checkoutarticle() throws InterruptedException {
        PageManager pageManager = new PageManager();

        // Login
        pageManager.getLoginPage().enterUserName("standard_user");
        pageManager.getLoginPage().enterPassword("secret_sauce");
        pageManager.getLoginPage().clickLoginButton();
        Assert.assertEquals(pageManager.getProductsPage().getPageTitle(), "Products",
                "Products page not found");

        // Add Items to Cart
        pageManager.getProductsPage().addItemToCart("Sauce Labs Backpack");
        pageManager.getProductsPage().addItemToCart("Sauce Labs Bike Light");
        Assert.assertEquals(pageManager.getProductsPage().getItemsAddedToCart(), "2",
                "Some products may not have been added");

        // Proceed to Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
               "Thank you for your order!", "Order Not Placed" );

        Thread.sleep(3000);



    }

}
