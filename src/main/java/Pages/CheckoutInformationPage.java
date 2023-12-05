package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutInformationPage {

    public static Logger Log = LogManager.getLogger(CheckoutInformationPage.class);
    Page page;
    public CheckoutInformationPage(Page page){
        this.page = page;
    }

    private static String continueButtonLocator = "//input[@name='continue']";

    public void provideDeliveryDetails(String... infoData){
        page.fill("//input[@name='firstName']", infoData[0]);
        Log.info("Entered first name : "+infoData[0]);
        page.fill("//input[@name='lastName']", infoData[1]);
        Log.info("Entered last name : "+infoData[1]);
        page.fill("//input[@name='postalCode']", infoData[2]);
        Log.info("Entered postalCode : "+infoData[2]);
    }

    public void clickContinueButton(){
        page.click(continueButtonLocator);
        Log.info("Clicked on continue button");
    }

}
