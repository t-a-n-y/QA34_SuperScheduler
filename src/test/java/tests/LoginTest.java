package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTest extends Configuration {

    @Test
    public void loginTestSuccess(){

        boolean addPresent = new SplashScreen(driver)
                .checkCurrentVersion("LOGIN")
                .fillEmail("tanya@gmail.ru")
                .fillPassword("Ttanya123$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);

    }

    @Test
    public void loginTestSuccess2(){

        boolean addPresent = new SplashScreen(driver)
                .checkCurrentVersion("LOGIN")
                .fillEmail("tanya@gmail.ru")
                .fillPassword("Ttanya123$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);

    }

    @Test
    public void loginSuccessModel(){
        User user = User.builder()
               .email("tanya@gmail.ru")
               .password("Ttanya123$")
               .build();
      boolean addPresent = new LoginScreen(driver)
               .complexLogin(user)
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginNegativeModelWrongPassword(){
        User user = User.builder()
                .email("tanya@gmail.ru")
                .password("Ttanya123")
                .build();
             new LoginScreen(driver)
                .complexLogin(user)
                .checkErrorMessage()
                .confirmError();//click Ok
    }

   // @AfterMethod
   // public void postCondition(){
    // new HomeScreen(driver)
    //         .openMenu()
    //         .logout();
   // }
}
