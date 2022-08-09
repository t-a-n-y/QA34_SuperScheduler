package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){

        type(emailEditText,email);
        //return new LoginScreen(driver);
        return this;
    }

    public LoginScreen fillPassword(String password){
        type(passwordEditText, password);
        return this;
    }

    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }

    public WizardScreen submitRegistration(){
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public HomeScreen complexLogin(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        submitLogin();
        return new HomeScreen(driver);
    }


}
