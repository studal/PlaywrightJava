package Pages;

import com.microsoft.playwright.Page;

public class LoginPage{

    private static String usernameFieldLocator = "//input[@id='user-name']";
    private static String passwordFieldLocator = "//input[@id='password']";
    private static String loginButtonLocator = "//input[@id='login-button']";

    static Page page;

    public LoginPage(Page page){
            this.page = page;
        }

    public void enterUserName(String userName){
        page.locator(usernameFieldLocator).fill(userName);
    }

    public void enterPassword(String password){
        page.locator(passwordFieldLocator).fill(password);
    }

    public void clickLoginButton(){
        page.locator(loginButtonLocator).click();
    }





}