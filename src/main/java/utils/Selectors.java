package utils;

import org.openqa.selenium.By;

public enum Selectors {

    MAIN_MENU_ELEMENT_A(StringValues.MAIN_MENU_ELEMENT_A),
    TEXT_FIELD_SEARCH_RESULT_ROW(StringValues.TEXT_FIELD_SEARCH_RESULT_ROW),
    WAIT_SPINNER(StringValues.WAIT_SPINNER),
    USER_TEXT_INPUTS(StringValues.USER_TEXT_INPUTS),
    DISTRIBUTION_LINES_LEFT_TABLE(StringValues.DISTRIBUTION_LINES_LEFT_TABLE_TABLE),
    DISTRIBUTION_LINES_RIGHT_TABLE(StringValues.DISTRIBUTION_LINES_RIGHT_TABLE_TABLE),
    DISTRIBUTION_LINES_LEFT_TABLE_HEADER_CELLS(StringValues.DISTRIBUTION_LINES_LEFT_TABLE_HEADER_TABLE),
    DISTRIBUTION_LINES_RIGHT_TABLE_HEADER_CELLS(StringValues.DISTRIBUTION_LINES_RIGHT_TABLE_HEADER_CELLS),
    SAVED_POPUP(StringValues.SAVED_POPUP);

    private String value;

    Selectors(String value) {
        this.value = value;
    }

    public String getValue () {
        return value;
    }

    public String getValue (String value) {
        return this.value.replace("[TEXT_TO_REPLACE]", value);
    }

    public By getBy () {
        if (this.value.startsWith("//")|| this.value.startsWith("./")) {
            return By.xpath(this.value);
        }
        return By.cssSelector(this.value);
    }

    public By getBy (String value) {
        if (this.value.startsWith("//") || this.value.startsWith("./")) {
            return By.xpath(this.value.replace("[TEXT_TO_REPLACE]", value));
        }
        return By.cssSelector(this.value.replace("[TEXT_TO_REPLACE]", value));
    }

    private static class StringValues {
        //GenericPage
        private static final String WAIT_SPINNER = "//*[@id='WAIT_win0']";
        private static final String SAVED_POPUP = "//*[@id='SAVED_win0']";

        //HeaderPage
        private static final String MAIN_MENU_ELEMENT_A = "//div[@class = 'pthnavscroll']//li/a[text()='[TEXT_TO_REPLACE]']";

        //GroupEntryPage
        private static final String TEXT_FIELD_SEARCH_RESULT_ROW = "//table[@class='PSSRCHRESULTSTITLE']//tr[.//span[@class = 'spanMatchText' and contains(text(),'[TEXT_TO_REPLACE]')]]";
        private static final String USER_TEXT_INPUTS = "//table[@id = 'ACE_PENDING_ITEM_USER1$0']//input";

        private static final String DISTRIBUTION_LINES_LEFT_TABLE_TABLE = "//table[@id = 'gbPENDING_DST$0']/tbody/tr/td[1]";
        private static final String DISTRIBUTION_LINES_RIGHT_TABLE_TABLE = "//table[@id = 'gbPENDING_DST$0']/tbody/tr/td[2]";
        private static final String DISTRIBUTION_LINES_LEFT_TABLE_HEADER_TABLE = "//table[@id = 'l1PENDING_DST$0']/tbody/tr/td/div/table/tbody/tr/td[1]//th";
        private static final String DISTRIBUTION_LINES_RIGHT_TABLE_HEADER_CELLS = "//table[@id = 'l1PENDING_DST$0']/tbody/tr/td/div/table/tbody/tr/td[2]//th";

    }

}