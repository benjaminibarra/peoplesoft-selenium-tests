package pageObjects.PS;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExplicitWait;

import java.rmi.server.ExportException;

@DefaultUrl("/psp/UFIUAT92/EMPLOYEE/ERP/?&cmd=login&languageCd=ENG")
public class LoginPage extends GenericPage {

    final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id="userid")
    WebElementFacade userIDInput;

    @FindBy(id="pwd")
    WebElementFacade passwordInput;

    @FindBy(name="Submit")
    WebElementFacade signInBtn;

    protected WebDriver driver = getDriver();

    public void setUserCredentials() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                ExplicitWait.explicitlyWaitForPresenceOfElement(getDriver(), 40, userIDInput);
                typeIntoInput(userIDInput, getUserID(), false);
                typeIntoInput(passwordInput, getUserPassword(), false);
                break;
            } catch (Exception e) {
                LOGGER.error("Login Page did not load properly! Refreshing page...");
                getDriver().navigate().refresh();
            }
            attempts++;
        }
    }

    public void clickSignInBtn () {
        clickElement(signInBtn);
    }

    public String getUserID () {
        return SystemEnvironmentVariables.createEnvironmentVariables().getProperty("ps.username");
    }

    public String getUserPassword () {
        return SystemEnvironmentVariables.createEnvironmentVariables().getProperty("ps.password");
    }
}
