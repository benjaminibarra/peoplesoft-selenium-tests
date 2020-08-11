package steps.PS;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import pageObjects.PS.HeaderPage;

public class GenericSteps {

    @ManagedPages
    HeaderPage headerPage;

    @Step
    public void when_I_open_a_menu (String ... menus) {
        headerPage.clickMainMenuBtn();
        headerPage.selectMenuFromDropdown(menus);
    }
}
