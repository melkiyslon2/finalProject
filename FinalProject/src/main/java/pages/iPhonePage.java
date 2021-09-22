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

}
