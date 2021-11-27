package appiumproject.pom;

import appiumproject.api.models.trip.TripResponse;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    AndroidDriver<MobileElement> driver;
    MobileElement emailField;
    MobileElement passwordField;
    private static final String DEFAULT_PASSWORD = "Testing123";

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/login")
    private MobileElement loginButton;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void enterEmail(String email){
        String emailText = "Your email";
        emailField = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+emailText+"\")");
        emailField.sendKeys(email);
    }

    private void enterPassword(String password){
        String passwordText = "Your password";
        passwordField = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+passwordText+"\")");
        passwordField.sendKeys(password);
    }

    public void logIn(TripResponse tripResponse) {
        waitForDisplayed(loginButton, driver);
        enterEmail(tripResponse.getBookingContact().getEmail());
        enterPassword(DEFAULT_PASSWORD);
        loginButton.click();
    }
}
