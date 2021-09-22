package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LaptopPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'LG')]")
    private List<WebElement> laptops;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private List<WebElement> goToCartButton;
    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement sortButton;
    @FindBy(xpath = "//a[@class='a-dropdown-link'][contains(text(),'Price: Low')]")
    private WebElement lowToHighPrice;
    @FindBy(xpath = "//span[@class='a-price']/span[@class='a-offscreen']")
    private List<WebElement> sortedItems;
    @FindBy(xpath = "//span[@class='a-dropdown-prompt'][contains(text(),'Price: Low to High')]")
    private WebElement getSortButtonText;

    public LaptopPage(WebDriver driver) {
        super(driver);
    }

    public void feature(){
        sortButton.click();
    }

    public void sort(){
        lowToHighPrice.click();
    }

    public void checkFeatureVisibility(){
        sortButton.isDisplayed();
    }

    public String checkIfSortWasEnabled(){
        return getSortButtonText.getText();
    }

}
