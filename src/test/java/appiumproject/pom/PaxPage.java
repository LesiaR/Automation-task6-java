package appiumproject.pom;

import appiumproject.api.models.trip.Name;
import appiumproject.api.models.trip.TripResponse;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PaxPage extends BasePage {

    AndroidDriver<MobileElement> driver;
    MobileElement firstNameField;
    MobileElement lastNameField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/passenger_title_mr")
    private MobileElement paxTitleMr;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/passenger_title_mrs")
    private MobileElement paxTitleMrs;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/passenger_title_ms")
    private MobileElement paxTitleMs;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/price_breakdown_cta")
    private MobileElement continueCta;

    public PaxPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void selectTitle(String title){
        if (title.equals("Mr")){
            paxTitleMr.click();
        }
        else if (title.equals("Ms")){
            paxTitleMs.click();
        }
        else {
            paxTitleMrs.click();
        }
    }

    private void enterFirstName(String firstName){
        String firstNameText = "First name";
        firstNameField = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+firstNameText+"\")");
        firstNameField.sendKeys(firstName);
    }

    private void enterLastName(String lastName){
        String lastNameText = "Last name";
        lastNameField = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+lastNameText+"\")");
        lastNameField.sendKeys(lastName);
    }

    public void enterPaxInfo(TripResponse tripResponse) {
        Name name = tripResponse.getBookingContact().getName();
        waitForDisplayed(paxTitleMr, driver);
        selectTitle(name.getTitle());
        enterFirstName(name.getFirst());
        enterLastName(name.getLast());
        continueCta.click();
    }
}
