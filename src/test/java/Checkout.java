import Base.BaseClass;
import Manager.PageManager;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends BaseClass {

    @Test
    public void checkoutarticle() throws InterruptedException {
        PageManager pageManager = new PageManager();
        pageManager.getLoginPage().enterUserName("standard_user");
        pageManager.getLoginPage().enterPassword("secret_sauce");
        pageManager.getLoginPage().clickLoginButton();

        Assert.assertEquals(pageManager.getProductsPage().getPageTitle(), "Products",
                "Products page not found");
        Thread.sleep(5000);
    }

}
