package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class,'a-text-normal')][contains(text(),'Apple iPhone X, 64GB')]")
    private WebElement iPhoneButton;
    @FindBy(xpath = "//span[contains(text(),'Apple iPhone 11 Pro Max')]")
    private WebElement pickIphone;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void openIphonePage(){
        iPhoneButton.click();
    }

    public void pickIphoneFromList(){
        pickIphone.click();
    }

}
