package pageObjects.PS;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.SystemEnvironmentVariables;

import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ExplicitWait;
import utils.Selectors;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GenericPage extends PageObject {

    public void openUrl() {
        open();
        setWindowSize();
    }

    public void waitForLoadingSpinner()  {
        waitForLoadingSpinner(2, 120);
    }


    public void waitForLoadingSpinner (int waitForVisibilitySeconds, int waitForInvisibilitySeconds) {
        setImplicitTimeout(0, ChronoUnit.MILLIS);
        ExplicitWait.explicitlyWaitForVisibilityOfElementIgnoreExceptions(getDriver(), waitForVisibilitySeconds, Selectors.WAIT_SPINNER.getBy()); //wait for the loading icon to show
        System.out.println("============APPEAR!");
        ExplicitWait.explicitlyWaitForInvisibilityOfElement(getDriver(), waitForInvisibilitySeconds,  Selectors.WAIT_SPINNER.getBy()); //wait for the loading icon to disappear
        System.out.println("============DISAPPEAR!");
        resetImplicitTimeout();
    }

    public void waitForSavedPopup()  {
        waitForSavedPopup(2, 120);
    }

    public void waitForSavedPopup (int waitForVisibilitySeconds, int waitForInvisibilitySeconds) {
        setImplicitTimeout(0, ChronoUnit.MILLIS);
        ExplicitWait.explicitlyWaitForVisibilityOfElementIgnoreExceptions(getDriver(), waitForVisibilitySeconds, Selectors.SAVED_POPUP.getBy()); //wait for the loading icon to show
        System.out.println("============APPEAR!");
        ExplicitWait.explicitlyWaitForInvisibilityOfElement(getDriver(), waitForInvisibilitySeconds,  Selectors.SAVED_POPUP.getBy()); //wait for the loading icon to disappear
        System.out.println("============DISAPPEAR!");
        resetImplicitTimeout();
    }

    public void selectFromOption (WebElementFacade selectElement , String option, String defaultSelectedOption, boolean clickOkNeeded) {
        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 10, selectElement);
        ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 10, selectElement);

        //Show all options
        clickElement(selectElement);

        Boolean moveDown = null;
        Integer numberOfMoves = null;
        int attempts = 0;
        while (attempts < 3) {
            try {

                //Wait for options to load
                ExplicitWait.explicitlyWaitForPresenceOfAllElements(getDriver(), 10, By.xpath(".//option"));

                //Check if chosen option is present
                WebElementFacade optionToSelect = selectElement.find(By.xpath(".//option[text() = '" + option + "']"));
                if (!optionToSelect.isPresent()) {
                    throw new ElementNotFoundException(optionToSelect.toString(), "<text>", option);
                }

                List<WebElementFacade> optionElements = selectElement.thenFindAll(By.xpath(".//option"));

                //Get the index of the currently selected option and the option to select
                List<String> optionElementsText = new ArrayList<>();
                optionElements.forEach(e -> optionElementsText.add(e.getText()));
                String selectedOptionText = selectElement.find(By.xpath(".//option[@selected = 'selected']")).getText();

                if (defaultSelectedOption != null) {
                    selectedOptionText = defaultSelectedOption;
                }

                String optionToSelectText = optionToSelect.getText();

                //Calculate the number of moves from currently selected option to the option to select
                int indexOfOptionToSelect = optionElementsText.indexOf(optionToSelectText);
                int indexOfSelectedOption = optionElementsText.indexOf(selectedOptionText);

                numberOfMoves = indexOfOptionToSelect - indexOfSelectedOption;
                moveDown = numberOfMoves >= 0; // (+) is down | (-) is up

                //Select option using keyboard commands
                for (int i = 0; i < Math.abs(numberOfMoves); i++) {
                    selectElement.sendKeys(moveDown ? Keys.ARROW_DOWN : Keys.ARROW_UP);
                    waitForLoadingSpinner(1, 30);
                }

                if (!clickOkNeeded) {
                    if (selectElement.find(By.xpath(".//option[@selected = 'selected']")).getText().equalsIgnoreCase(option)) {
                        break;
                    } else {
                        System.out.println("Option not selected propertly! Retrying...");
                    }
                } else {
                    break;
                }

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Exception thrown! Retrying...");
            } catch (ElementNotVisibleException e) {
                System.out.println("Element Not Visible Exception thrown! Retrying...");
            }
            attempts++;
        }
    }

    public void javaScriptClick (WebElementFacade element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void setWindowSize () {
        boolean headlessMode = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("headless.mode"));
        if (headlessMode) {
            getDriver().manage().window().setSize(new Dimension(1920, 1080));
        } else {
            getDriver().manage().window().maximize();
        }
    }

    public void switchToPtIFrame() {
        switchToIframe("ptifrmtgtframe");
    }

    public void switchToIframe (String nameOrId) {
        getDriver().switchTo().frame(nameOrId);
    }

    public void switchToBaseDom() {
        getDriver().switchTo().defaultContent();
    }

    public void clickElement (By element) {
        scrollIntoView(element);
        ExplicitWait.explicitlyWaitForElementToBeClickableIgnoreException(getDriver(), 30, element);
        find(element).click();
    }

    public void clickElement (WebElementFacade element) {
        long s = System.currentTimeMillis();
        ExplicitWait.explicitlyWaitForPresenceOfElement(getDriver(), 20, element);
        scrollElementIntoView(element);
        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 20, element);
        element.click();
        long e = System.currentTimeMillis();
        System.out.println("CLICKED ====> " + (e - s));
    }

    public void typeIntoInput (WebElementFacade input, String text, boolean waitForInputToBeEntered) {
        long s = System.currentTimeMillis();
        int attempts = 0;
        while (attempts < 3) {
            ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 30, input);
            scrollElementIntoView(input);
            ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 20, input);
            input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), text);
            if (waitForInputToBeEntered) {
                waitForLoadingSpinner(3, 120);
                waitABit(2000);
            }
            if (input.getAttribute("value").contains(text)) {
                break;
            } else {
                System.out.println("Typing into text field failed! Retrying...");
            }
            attempts++;
        }
        long e = System.currentTimeMillis();
        System.out.println("TYPE ==> " + (e - s));
    }

    public void typeIntoInput (WebElementFacade input, String text) {
        typeIntoInput(input, text, true);
    }

    public void typeAndSelectSearchResultFromPopUp(WebElementFacade input, String text, boolean waitForInputToBeEntered) {
        long s = System.currentTimeMillis();
        int attempts = 0;
        while (attempts < 3) {
            typeIntoInput(input, text, waitForInputToBeEntered);
            waitForLoadingSpinner(2, 120);
            List<WebElementFacade> searchResultRows = findAll(Selectors.TEXT_FIELD_SEARCH_RESULT_ROW.getBy(text));
            try {
                ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 20, searchResultRows.get(0));
            } catch (Exception e) {
                attempts++;
                System.out.println("Exception Thrown! Retrying...");
                continue;
            }
            try {
                clickElement(searchResultRows.get(0));
            } catch (ElementNotInteractableException e) {
                attempts++;
                System.out.println("ElementNotInteractableException Thrown! Retrying...");
                continue;
            }
            break;
        }
        long e = System.currentTimeMillis();
        System.out.println("TYPE SELECT ==> " + (e - s));
    }

    public void typeAndSelectSearchResultFromPopUp(WebElementFacade input, String text) {
        typeAndSelectSearchResultFromPopUp(input, text, true);
    }

    public void scrollIntoView(By elementBy) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(" + true + ");", find(elementBy));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(" + false + ");", find(elementBy));
    }

    public void scrollElementIntoView(WebElementFacade element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(" + true + ");", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(" + false + ");", element);
    }

}
