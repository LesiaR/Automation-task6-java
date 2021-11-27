package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PotentialTripPage extends BasePage {

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/price_breakdown_cta")
    private MobileElement continueCta;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/title")
    private MobileElement cardFirst;

    public PotentialTripPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void openPayment() {
        waitForDisplayed(cardFirst, driver);
        waitForDisplayed(continueCta, driver);
        continueCta.click();
    }
}
