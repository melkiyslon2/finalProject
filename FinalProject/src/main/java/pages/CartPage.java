package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.security.Key;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    private WebElement getQuantity;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;
    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement chooseChangeAmountButton;
    @FindBy(xpath = "//a[@id='quantity_2']")
    private WebElement chooseAmount;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantityInCart(){
        System.out.println(getQuantity);
        return getQuantity.getText();
    }

    public void searchFieldIsDisplayed(){
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String keyWord){
        searchField.clear();
        searchField.sendKeys(keyWord, Keys.ENTER);
    }

    public void addPhoneToCart(){
        chooseChangeAmountButton.isDisplayed();
        chooseChangeAmountButton.click();
        chooseAmount.isDisplayed();
        chooseAmount.click();
    }
}
