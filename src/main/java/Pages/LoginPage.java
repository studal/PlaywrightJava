package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage{

    public static Logger Log = LogManager.getLogger(LoginPage.class);

    private static String usernameFieldLocator = "//input[@id='user-name']";
    private static String passwordFieldLocator = "//input[@id='password']";
    private static String loginButtonLocator = "//input[@id='login-button']";

    Page page;

    public LoginPage(Page page){
            this.page = page;
        }

    public void enterUserName(String userName){
        page.locator(usernameFieldLocator).fill(userName);
        Log.info("User name Entered : "+userName);
    }

    public void enterPassword(String password){
        page.locator(passwordFieldLocator).fill(password);
        Log.info("Password entered : "+password);
    }

    public void clickLoginButton(){
        page.locator(loginButtonLocator).click();
        Log.info("Clicked on login button");
    }

}