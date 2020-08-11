package utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ExplicitWait {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExplicitWait.class);

    private static WebDriverWait getWebDriverWaitInstance (WebDriver driver, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.ignoring(
                NoSuchElementException.class,
                TimeoutException.class
        );
        wait.pollingEvery(100, TimeUnit.MILLISECONDS);
        return wait;
    }

    public static void explicitlyWaitForVisibilityOfElement (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public static void explicitlyWaitForVisibilityOfElementIgnoreExceptions(WebDriver driver, int seconds, By elementBy) {
        try {
            getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        } catch (Exception e) {
            LOGGER.info("Element " + elementBy.toString() + " did not became visible!");
        }
    }

    public static void explicitlyWaitForVisibilityOfElementIgnoreExceptions(WebDriver driver, int seconds, WebElementFacade element) {
        try {
            getWebDriverWaitInstance(driver, seconds).until(visibilityOfElementLocated(element));
        } catch (Exception e) {
            LOGGER.info("Element " + element + " did not became visible!");
        }
    }

    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final WebElementFacade element) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    return elementIfVisible(element);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "visibility of element located by " + element;
            }
        };
    }

    private static WebElement elementIfVisible(WebElement element) {
        return element.isDisplayed() ? element : null;
    }


    public static void explicitlyWaitForInvisibilityOfElement (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public static void explicitlyWaitForAbsenceOfElement (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.numberOfElementsToBeLessThan(elementBy, 1));
    }

    public static void explicitlyWaitForNumberOfElementsToBe (WebDriver driver, int seconds, By elementBy, int expectedNumber) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.numberOfElementsToBe(elementBy, expectedNumber));
    }

    public static void explicitlyWaitForNumberOfElementsToBeMoreThan (WebDriver driver, int seconds, By elementBy, int expectedNumber) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.numberOfElementsToBeMoreThan(elementBy, expectedNumber));
    }

    public static void explicitlyWaitForNumberOfElementsToBeLessThan (WebDriver driver, int seconds, By elementBy, int expectedNumber) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.numberOfElementsToBeLessThan(elementBy, expectedNumber));
    }

    public static void explicitlyWaitForElementToBeClickable (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public static void explicitlyWaitForElementToBeClickableIgnoreException (WebDriver driver, int seconds, By elementBy) {
        try {
            getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.elementToBeClickable(elementBy));
        } catch (Exception e) {
            LOGGER.error("Element " + elementBy + " did not became clickable!");
        }
    }

    public static void explicitlyWaitForElementToBeClickableIgnoreException (WebDriver driver, int seconds, WebElementFacade element) {
        try {
            getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            LOGGER.error("Element " + element + " did not became clickable!");
        }
    }

    public static void explicitlyWaitForElementToBeClickable (WebDriver driver, int seconds, WebElementFacade element) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void explicitlyWaitForVisibilityOfElement (WebDriver driver, int seconds, WebElementFacade element) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void explicitlyWaitForPresenceOfAllElements (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    public static void explicitlyWaitForVisibilityOfAllElements (WebDriver driver, int seconds, By elementBy) {
        getWebDriverWaitInstance(driver, seconds).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public static void explicitlyWaitForInvisibilityOfElement (WebDriver driver, int seconds, WebElementFacade element) {
        getWebDriverWaitInstance(driver, seconds).until(invisibilityOf(element));
    }

    public static ExpectedCondition<Boolean> invisibilityOf(final WebElement element) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                return !element.isDisplayed();
            }

            @Override
            public String toString() {
                return "invisibility of " + element;
            }
        };
    }

    public static void explicitlyWaitForPresenceOfElement(WebDriver driver, int seconds, WebElementFacade element) {
        getWebDriverWaitInstance(driver, seconds).until(presenceOfElementLocated(element));
    }

    public static void explicitlyWaitForPresenceOfElementIgnoreException(WebDriver driver, int seconds, WebElementFacade element) {
        try {
            getWebDriverWaitInstance(driver, seconds).until(presenceOfElementLocated(element));
        } catch (Exception e) {
            LOGGER.error("Element " + element + " did not became present!");
        }
    }


    public static ExpectedCondition<WebElementFacade> presenceOfElementLocated(final WebElementFacade element) {
        return new ExpectedCondition<WebElementFacade>() {
            @Override
            public WebElementFacade apply(WebDriver driver) {
                return element.isPresent() ? element : null;
            }

            @Override
            public String toString() {
                return "presence of element located by: " + element.toString();
            }
        };
    }
}
