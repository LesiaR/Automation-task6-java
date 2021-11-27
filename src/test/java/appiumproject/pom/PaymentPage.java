package appiumproject.pom;

import appiumproject.api.models.trip.TripResponse;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/accept_insurance")
    private MobileElement acceptIns;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/reject_insurance")
    private MobileElement rejectIns;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/add_card_manually")
    private MobileElement newCard;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/payment_terms_and_conditions")
    private MobileElement acceptTC;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/payment_price_breakdown_cta")
    private MobileElement paynowButton;

    @AndroidFindBy(id = "android.widget.LinearLayout")
    private MobileElement popUpContainer;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/btn_primary")
    private MobileElement tryAgain;

    public PaymentPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void rejectInsurance(){
        waitForDisplayed(rejectIns, driver);
        rejectIns.click();
        swipeToBottom(rejectIns, acceptIns, driver);
    }

    private void selectNewCard(){
        waitForDisplayed(newCard, driver);
        newCard.click();
    }

    private void acceptTcPay(){
        waitForDisplayed(paynowButton, driver);
        paynowButton.click();
        waitLoaded(5);
        acceptTC.click();
        paynowButton.click();
    }

    public void paymentWithNewCard(CardDetailsPage cardDetailsPage, TripResponse tripResponse){
        rejectInsurance();
        selectNewCard();
        cardDetailsPage.fillCardDetails(tripResponse);
        acceptTcPay();
    }

    public void declinedPopUpDisplayed(){
        waitForDisplayed(tryAgain, driver);
        String declinedText = "Your payment has been declined. Do you want to try another card?";
        MobileElement declinedPopUp = driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+declinedText+"\")");
        Assert.assertTrue(declinedPopUp.isDisplayed());
    }
}
