package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement versionTextView;

    public String getCurrencyVersion(){
        return versionTextView.getText();
    }

    public LoginScreen checkCurrentVersion( String version){
        shouldHave(versionTextView, version, 10);

        return new LoginScreen(driver);
    }
}
