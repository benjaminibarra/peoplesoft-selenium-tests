package steps.PS;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import pageObjects.PS.LoginPage;

public class LoginSteps extends GenericSteps {

    @ManagedPages
    LoginPage loginPage;

    @Step
    public void when_I_open_the_login_page () {
        loginPage.openUrl();
    }

    @Step
    public void when_I_set_user_credentials () {
        loginPage.setUserCredentials();
    }

    @Step
    public void when_I_click_Sign_In_button () {
        loginPage.clickSignInBtn();
    }

    @Step
    public void given_that_im_logged_in_to_PeopleSoft_page () {
        when_I_open_the_login_page();
        when_I_set_user_credentials();
        when_I_click_Sign_In_button();
    }
}
