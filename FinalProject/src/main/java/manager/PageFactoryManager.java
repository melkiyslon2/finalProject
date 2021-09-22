package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LaptopPage getLaptopPage(){
        return new LaptopPage(driver);
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }

    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }

    public iPhonePage getIPhonePage(){
        return new iPhonePage(driver);
    }

    public CartPage getCartPage(){
        return new CartPage(driver);
    }

}
