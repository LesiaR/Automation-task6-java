package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FlightPage extends BasePage {

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/card_container")
    private MobileElement firstFlightCard;

    private MobileElement targetFlightCard;

    public FlightPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectFlight(String flightNumberText){
        waitForDisplayed(firstFlightCard, driver);
        String id = "com.ryanair.cheapflights.qadebug:id/card_container";
        targetFlightCard = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+id+"\")" +
                ".childSelector(new UiSelector().text(\""+flightNumberText+"\"))");
        targetFlightCard.click();
    }
}
