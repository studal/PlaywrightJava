package scenarios;

import Base.BaseClass;
import Manager.PageManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends BaseClass {

    @Test
    public void checkoutarticle() throws InterruptedException {

        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);
    }

    @Test
    public void checkoutarticle2() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

    @Test
    public void checkoutarticle232() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

    @Test
    public void checkoutartic234le2() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

    @Test
    public void checkou42342tarticle2() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

    @Test
    public void checkoudasdtarticle2() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

    @Test
    public void checkoutaasdarticle2() throws InterruptedException {
        PageManager pageManager = launchBrowserAndApp();

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

        // Proceed to scenarios.Checkout Item
        pageManager.getProductsPage().goToCart();
        pageManager.getYourCartPage().clickCheckoutButton();

        // Provide Information
        pageManager.getCheckoutInformationPage().provideDeliveryDetails("Sandy", "N", "zipcode");
        pageManager.getCheckoutInformationPage().clickContinueButton();

        // scenarios.Checkout Items
        pageManager.getCheckoutOverviewPage().clickFinishButton();
        Assert.assertEquals(pageManager.getCheckoutCompletePage().getCompleteOrderMessage(),
                "Thank you for your order!", "Order Not Placed");

        Thread.sleep(3000);

    }

}
