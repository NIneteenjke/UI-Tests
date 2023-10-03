package lib.ui;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) { this.driver = driver; }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        return switch (byType) {
            case "xpath" -> By.xpath(locator);
            case "id" -> By.id(locator);
            case "css" -> By.cssSelector(locator);
            default -> throw new IllegalArgumentException("Cannot get type of locator  " + locatorWithType);
        };
    }

    public void waitForElementAndClick(String locator, String errorMessage, long TimeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, TimeoutInSeconds);
        element.click();
    }

    public void waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
    }

    public void waitForElementNotPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void tapByCoordinates(int by_x, int by_y) {
//        RemoteWebDriver remoteDriver = driver;
        PerformsTouchActions performsTouchActions = (PerformsTouchActions) driver;
        TouchAction touchAction = new TouchAction(performsTouchActions);
        touchAction.tap(PointOption.point(by_x, by_y)).perform();
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUpToFindElement(String locator, String errorMessage, int maxSwipes) {
        By by = this.getLocatorByString(locator);
        int alreadySwiped = 0;
        while (driver.findElements(by).isEmpty()) {

            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void swipeUp(int timeOfSwipe) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int startY = (int) (size.height * 0.8);
            int endY = (int) (size.height * 0.2);
            action.press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, endY))
                    .release()
                    .perform();
    }

    public void swipeUpQuick() { swipeUp(200); }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementIsPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements == 0) {
            String default_message = "An element '" + locator + "' is not there";
            throw new AssertionError(default_message + " " + errorMessage);
        }
    }

    public void assertElementNotPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements > 0) {
            String default_message = "An element '" + locator + "' is not there";
            throw new AssertionError(default_message + " " + errorMessage);
        }
    }

    public void getElementsWithDifferentLocators(List<String> locators) {
        List<WebElement> elements = new ArrayList<>();

        for (String locator : locators) {
            By by = getLocatorByString(locator);
            List<WebElement> foundElements = driver.findElements(by);

            if (foundElements.isEmpty()) {
                throw new NoSuchElementException("Element not found for locator: " + locator);
            }

            elements.addAll(foundElements);
        }
    }
}