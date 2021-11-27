package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SeatsPage extends BasePage {
    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/pick_proposal_button")
    private MobileElement pickSeats;

    public SeatsPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void confirmSeats() {
        waitForDisplayed(pickSeats, driver);
        pickSeats.click();
    }
}
