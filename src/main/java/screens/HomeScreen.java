package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;

    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logoutButton;

    @FindBy (xpath = "//*[contains(@text,'Wrong email or password')]")
    MobileElement errorText;

    @FindBy (xpath = "//*[@resource-id='android:id/button1']")
    MobileElement buttonOk;



    public HomeScreen checkFabButtonPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }

    public boolean isFabAddPresent(){
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }

    public LoginScreen logout(){
       logoutButton.click();
        return new LoginScreen(driver);
    }

    public HomeScreen checkErrorMessage() {
        should(errorText,10);
        Assert.assertTrue(errorText.isDisplayed());
        return this;
    }

    public void confirmError() {
        buttonOk.click();

    }

}
