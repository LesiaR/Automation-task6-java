package appiumproject.pom;

import appiumproject.api.models.trip.Address;
import appiumproject.api.models.trip.CreditCard;
import appiumproject.api.models.trip.TripResponse;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CardDetailsPage extends BasePage {

    public final static String DECLINED_CARD_NUMBER = "5100000014101198";

    AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/credit_card")
    private MobileElement cardNumberField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/expire_date")
    private MobileElement expDateField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/securityCodeText")
    private MobileElement cvv;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/cardholder_name")
    private MobileElement cardholderField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/street_address")
    private MobileElement streetAdressField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/city")
    private MobileElement cityField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/country")
    private MobileElement countryField;

    @AndroidFindBy(id = "android:id/search_src_text")
    private MobileElement searchCountryField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/postcode")
    private MobileElement postcodeField;

    @AndroidFindBy(id = "com.ryanair.cheapflights.qadebug:id/confirm")
    private MobileElement confirmButton;

    public CardDetailsPage(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void enterCardNumber(CreditCard creditCard){
        waitForDisplayed(cardNumberField, driver);
        cardNumberField.sendKeys(DECLINED_CARD_NUMBER);
        String exDt = creditCard.getExpiryDate();
        exDt = exDt.substring(0,2)+"/"+exDt.substring(2);
        expDateField.sendKeys(exDt);
        cvv.sendKeys(creditCard.getCardCvv());
    }

    private void enterCardholder(String cardholder){
        cardholderField.sendKeys(cardholder);
    }

    private void enterStreetAdress(String adress){
        streetAdressField.sendKeys(adress);
    }

    private void enterCity(String city){
        cityField.sendKeys(city);
    }

    private void enterCountry(String country){
        countryField.click();
        waitForDisplayed(searchCountryField, driver);
        searchCountryField.sendKeys(country);
        countryField.click();
        waitForDisplayed(confirmButton, driver);
        confirmButton.click();
    }

    private void enterPostcode(String postcode){
        waitForDisplayed(postcodeField, driver);
        postcodeField.sendKeys(postcode);
    }

    public void fillCardDetails(TripResponse tripResponse){
        CreditCard creditCard = tripResponse.getBookingContact().getCreditCard();
        Address address = tripResponse.getBookingContact().getAddress();
        enterCardNumber(creditCard);
        enterCardholder(creditCard.getCardHolder());
        enterStreetAdress(address.getLine1());
        enterCity(address.getCity());
        enterCountry(address.getCountry());
        enterPostcode(address.getPostal());
        confirmButton.click();
    }
}
