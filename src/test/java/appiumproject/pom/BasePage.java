package appiumproject.pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class BasePage {

    public final static int TIMEOUT = 80;

    protected void waitForDisplayed(MobileElement mobileElement, AndroidDriver<MobileElement> driver){
        WebDriverWait wait = new WebDriverWait (driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    protected static void waitLoaded(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void swipeToBottom(MobileElement element1, MobileElement element2, AndroidDriver<MobileElement> driver )
    {
        TouchAction ta = new TouchAction(driver);
        Point pointEl1 = element1.getLocation();
        Point pointEl2 = element2.getLocation();
        PointOption point = new PointOption();
        ta
                .press(point.point(pointEl1))
                .moveTo(point.point(pointEl2))
                .release()
                .perform();
    }

    public LocalDate convertDate(String date){
        String pattern = "yyyy-MM-d";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return parsedDate;
    }

}
