package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class='nav-action-inner']")
    private WebElement signIn;
    @FindBy(xpath = "//span[@id='nav-your-amazon-text']")
    private WebElement userName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void signIn(){
        signInButton.click();
    }

    public String userAccount(){
        userName.isDisplayed();
        return userName.getText();
    }
}
