package pageObjects.PS;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.ExplicitWait;
import utils.Selectors;

public class HeaderPage extends GenericPage {

    @FindBy(id = "pthnavbca_PORTAL_ROOT_OBJECT")
    WebElementFacade mainMenuBtnAnchor;

    @FindBy(id = "pthnavfly_PORTAL_ROOT_OBJECT")
    WebElementFacade mainMenuDropdownBaseDiv;

    @FindBy(className = "pthnavshadow")
    WebElementFacade mainMenuDropdownDiv;

    @FindBy(id = "pthnavsrchinput")
    WebElementFacade menuSearchFieldInput;

    public void clickMainMenuBtn() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 40, mainMenuBtnAnchor);
                break;
            } catch (Exception e) {
                getDriver().navigate().refresh();
            }
            attempts++;
        }
        clickElement(mainMenuBtnAnchor);
    }

    public void selectMenuFromDropdown (String ... menus) {
        for (String menu : menus) {
            WebElementFacade menuA = find(Selectors.MAIN_MENU_ELEMENT_A.getBy(menu));
            clickElement(menuA);
        }
        waitForLoadingSpinner();
    }

}
