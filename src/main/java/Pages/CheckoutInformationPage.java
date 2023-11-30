package Pages;

import com.microsoft.playwright.Page;

public class CheckoutInformationPage {
    Page page;
    public CheckoutInformationPage(Page page){
        this.page = page;
    }

    private static String continueButtonLocator = "//input[@name='continue']";

    public void provideDeliveryDetails(String... infoData){
        page.fill("//input[@name='firstName']", infoData[0]);
        page.fill("//input[@name='lastName']", infoData[1]);
        page.fill("//input[@name='postalCode']", infoData[2]);
    }

    public void clickContinueButton(){
        page.click(continueButtonLocator);
    }

}
