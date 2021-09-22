package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement countryChoose;
    @FindBy(xpath = "//a[contains(text(),'Ukraine')]")
    private WebElement enterCountry;
    @FindBy(xpath = "//input[@id='account-fixup-phone-number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void emailEnter(final String email){
        emailField.sendKeys(email, Keys.ENTER);
    }

    public void passwordEnter(final String password){
        passwordField.sendKeys(password,Keys.ENTER);
    }

    public void phoneNumberEnter(final String number){
        countryChoose.click();
        enterCountry.click();
        phoneNumberField.sendKeys(number,Keys.ENTER);
    }

    public String nonCorrectPasswordMessage(){
        return errorMessage.getText();
    }

}
