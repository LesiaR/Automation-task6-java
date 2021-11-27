package appiumproject.steps;

import appiumproject.SetUp;
import appiumproject.api.models.trip.TripRequest;
import appiumproject.pom.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestContext {

    private AndroidDriver<MobileElement> driver;
    private TripRequest tripRequest;
    private HomePage homePage;
    private SearchPage searchPage;
    private CalendarPage calendarPage;
    private FlightPage flightPage;
    private FarePage farePage;
    private PaxPage paxPage;
    private SeatsPage seatsPage;
    private BagsPage bagsPage;
    private PotentialTripPage potentialTripPage;
    private MandatoryLoginPage mandatoryLoginPage;
    private LoginPage loginPage;
    private PaymentPage paymentPage;
    private CardDetailsPage cardDetailsPage;


    public TestContext() {

        driver = SetUp.setCapabilitiesAppium();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        calendarPage = new CalendarPage(driver);
        flightPage = new FlightPage(driver);
        farePage = new FarePage(driver);
        paxPage = new PaxPage(driver);
        seatsPage = new SeatsPage(driver);
        bagsPage = new BagsPage(driver);
        potentialTripPage = new PotentialTripPage(driver);
        mandatoryLoginPage = new MandatoryLoginPage(driver);
        loginPage = new LoginPage(driver);
        paymentPage = new PaymentPage(driver);
        cardDetailsPage = new CardDetailsPage(driver);
        tripRequest = new TripRequest();
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public TripRequest getTripRequest() {
        return tripRequest;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public CalendarPage getCalendarPage() {
        return calendarPage;
    }

    public FlightPage getFlightPage() {
        return flightPage;
    }

    public FarePage getFarePage() {
        return farePage;
    }

    public PaxPage getPaxPage() {
        return paxPage;
    }

    public SeatsPage getSeatsPage() {
        return seatsPage;
    }

    public BagsPage getBagsPage() {
        return bagsPage;
    }

    public PotentialTripPage getPotentialTripPage() {
        return potentialTripPage;
    }

    public MandatoryLoginPage getMandatoryLoginPage() {
        return mandatoryLoginPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PaymentPage getPaymentPage() {
        return paymentPage;
    }

    public CardDetailsPage getCardDetailsPage() {
        return cardDetailsPage;
    }
}
