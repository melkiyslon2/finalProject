package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iPhonePage extends BasePage{

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
    private WebElement goToCartButton;
    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement changeQuantityButton;
    @FindBy(xpath = "//a[@id='quantity_1']")
    private WebElement chooseQuantity;

    @FindBy(xpath = "//button[@id='a-autoid-7-announce']")
    private WebElement changeCapacity;
    @FindBy(xpath = "//div[@id='availability']/span[@class='a-size-medium a-color-price']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[contains(text(),'Apple iPhone 11 Pro')]")
    private WebElement iPhone11;

    public iPhonePage(WebDriver driver) {
        super(driver);
    }

    public void addToTheCart(){
        addToCartButton.click();
    }

    public void goToCart(){
        goToCartButton.click();
    }

    public void changeQuantity(){
        changeQuantityButton.click();
        chooseQuantity.click();
    }

    public void changeCapacity(){
        changeCapacity.click();
    }

    public String errorMessage(){
        waitForPageLoadComplete(10);
        return errorMessage.getText();
    }

    public void loadIPhone(){
        iPhone11.click();
    }

}
