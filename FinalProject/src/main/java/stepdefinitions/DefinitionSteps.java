package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    LaptopPage laptopPage;
    SignInPage signInPage;
    SearchPage searchPage;
    iPhonePage iphonePage;
    CartPage cartPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User check feature visibility")
    public void checkFeatureVisibility(){
        laptopPage = pageFactoryManager.getLaptopPage();
        laptopPage.checkFeatureVisibility();
    }

    @And("User makes search by keyword {string}")
    public void searchByKeyWord(final String keyword){
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton(){
        homePage.clickSearchButton();
    }

    @And("User checks that url contains keyword {string}")
    public void checkUrlContainsKeyword(final String keyword) {
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User click 'Featured' button")
    public void featuredButtonClick(){
        laptopPage.feature();
    }

    @And("User click sortByPrice button")
    public void sort(){
        laptopPage.sort();
    }

    @And("User check is sort was enabled")
    public void checkSort(){
        laptopPage.checkIfSortWasEnabled();
    }

    @And("User checks if goods was sorted correctly")
    public void checkPrice(){
        assertTrue(laptopPage.checkIfSortWasEnabled().contains("Price: Low to High"));
    }

    @And("User click signIn button")
    public void signIn(){
        homePage.signIn();
    }

    @And("User enters email {string}")
    public void emailField(final String email) throws InterruptedException {
        Thread.sleep(3000); //Это необходимо, иначе сайт требует ввод капчи
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.emailEnter(email);
    }

    @And("User enters password {string}")
    public void passwordField(final String password) throws InterruptedException {
        Thread.sleep(3000); //Это необходимо, иначе сайт требует ввод капчи
        signInPage.passwordEnter(password);
    }

    @And("User enters phone number {string}")
    public void phoneNumberEnter(final String number) throws InterruptedException {
        Thread.sleep(3000); //Это необходимо, иначе сайт требует ввод капчи
        signInPage.phoneNumberEnter(number);
    }

    @And("User checks if he is loggined")
    public void checkIfUserLogginedIn(){
        assertEquals(homePage.userAccount(),"Mykola's Amazon.com");
    }

    @And("User clicks on the phone")
    public void clickOnThePhone(){
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.openIphonePage();
    }

    @And("User click add to cart button")
    public void addToCart(){
        iphonePage = pageFactoryManager.getIPhonePage();
        iphonePage.addToTheCart();
    }

    @And("User goes to cart")
    public void goToCart(){
        iphonePage.goToCart();
    }

    @And("User check amount of products in cart {string}")
    public void checkAmountInCart(final  String quantity){
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(cartPage.getQuantityInCart().contains(quantity));
    }


    @And("User enters {string} to searchField")
    public void enterTextToSearchField(final String searchText){
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.enterTextToSearchField(searchText);
    }

    @And("User clicks on 'iPhone 11'")
    public void clickOnIphoneFromList(){
        searchPage.pickIphoneFromList();
    }

    @And("User change the quantity")
    public void changeTheQuantity(){
        iphonePage = pageFactoryManager.getIPhonePage();
        iphonePage.changeQuantity();
    }

    @And("User gets error message")
    public void getErrorMessage(){
        signInPage.nonCorrectPasswordMessage();
    }

    @And("User check that he have got errorMessage")
    public void checkIfUserGetsMessageAboutNonCorrectPassword(){
        assertEquals(signInPage.nonCorrectPasswordMessage(),"Your password is incorrect");
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
