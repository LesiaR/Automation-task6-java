package appiumproject.steps;

import appiumproject.api.models.HttpClient;
import appiumproject.api.models.trip.TripRequest;
import appiumproject.api.models.trip.TripResponse;
import appiumproject.pom.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    TestContext testContext;
    AndroidDriver<MobileElement> driver;
    TripRequest tripRequest;
    TripResponse tripResponse;
    HomePage homePage;
    SearchPage searchPage;
    CalendarPage calendarPage;
    FlightPage flightPage;
    FarePage farePage;
    PaxPage paxPage;
    SeatsPage seatsPage;
    BagsPage bagsPage;
    PotentialTripPage potentialTripPage;
    MandatoryLoginPage mandatoryLoginPage;
    LoginPage loginPage;
    PaymentPage paymentPage;
    CardDetailsPage cardDetailsPage;


    public StepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        driver = testContext.getDriver();
        tripRequest = testContext.getTripRequest();
        homePage = testContext.getHomePage();
        searchPage = testContext.getSearchPage();
        calendarPage = testContext.getCalendarPage();
        flightPage = testContext.getFlightPage();
        farePage = testContext.getFarePage();
        paxPage = testContext.getPaxPage();
        seatsPage = testContext.getSeatsPage();
        bagsPage = testContext.getBagsPage();
        potentialTripPage = testContext.getPotentialTripPage();
        mandatoryLoginPage = testContext.getMandatoryLoginPage();
        loginPage = testContext.getLoginPage();
        paymentPage = testContext.getPaymentPage();
        cardDetailsPage = testContext.getCardDetailsPage();
    }

    @Given("^Basic booking on env: (.*)$")
    public void set_basic_booking(String env) {
//        Basic booking -> 1A Value Single
        tripRequest.setEnv(env);
    }

    @Given("^Booking Constraint: (.*)$")
    public void set_booking_constraint(String bookingConstraint){
        tripRequest.setBookingConstraint(bookingConstraint);
    }

    @Given("^I am on Payment page for selected trip$")
    public void i_am_on_payment_page_for_selected_trip() {
        tripResponse = HttpClient.getTrip(tripRequest);
        homePage.openSearch();
        searchPage.searchForOnewayTrip(tripResponse, calendarPage);
        flightPage.selectFlight(tripResponse.getOutBoundJourney().getFlightNumber());
        farePage.selectValueFare();
        paxPage.enterPaxInfo(tripResponse);
        seatsPage.confirmSeats();
        bagsPage.selectPBBag();
        potentialTripPage.openPayment();
        mandatoryLoginPage.openLogin();
        loginPage.logIn(tripResponse);
    }

    @When("^I pay with invalid card data$")
    public void i_pay_with_invalid_card_data() {
        paymentPage.paymentWithNewCard(cardDetailsPage, tripResponse);
    }

    @Then("^Declined pop-up is displayed$")
    public void declined_pop_up_is_displayed() {
        paymentPage.declinedPopUpDisplayed();
    }
}
