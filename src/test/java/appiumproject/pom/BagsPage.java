package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BagsPage extends BasePage {

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/option1")
    private MobileElement firstBagOption;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/price_breakdown_cta")
    private MobileElement continueCta;

    public BagsPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectPBBag() {
        waitForDisplayed(firstBagOption, driver);
        firstBagOption.click();
        continueCta.click();
    }
}
