package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FarePage extends BasePage {

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/standard_fare")
    private MobileElement valueFare;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/price_breakdown_cta")
    private MobileElement continueCta;

    public FarePage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectValueFare(){
        waitForDisplayed(valueFare, driver);
        valueFare.click();
        waitForDisplayed(continueCta, driver);
        continueCta.click();
    }
}
