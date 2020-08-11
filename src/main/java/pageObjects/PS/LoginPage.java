package pageObjects.PS;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import utils.ExplicitWait;

@DefaultUrl("/psp/UFIUAT92/EMPLOYEE/ERP/?&cmd=login&languageCd=ENG")
public class LoginPage extends GenericPage {

    @FindBy(id="userid")
    WebElementFacade userIDInput;

    @FindBy(id="pwd")
    WebElementFacade passwordInput;

    @FindBy(name="Submit")
    WebElementFacade signInBtn;

    protected WebDriver driver = getDriver();

    public void setUserCredentials() {
        ExplicitWait.explicitlyWaitForPresenceOfElement(getDriver(), 120, userIDInput);
        typeIntoInput(userIDInput, getUserID(), false);
        typeIntoInput(passwordInput, getUserPassword(), false);
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
