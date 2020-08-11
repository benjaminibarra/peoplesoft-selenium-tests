package pageObjects.PS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import utils.ExplicitWait;
import utils.Selectors;

import java.util.ArrayList;
import java.util.List;

public class GroupEntryPage extends GenericPage {

    @FindBy(xpath = "//a[@aria-label = 'Add a New Value'] | //a[.//*[text() = 'Add a New Value']]")
    WebElementFacade addANewValue;

    @FindBy(xpath = "//a[@aria-label = 'Find an Existing Value'] | //a[.//*[text() = 'Find an Existing Value']]")
    WebElementFacade findAnExistingValue;

    @FindBy(xpath = "//div[@class = 'ps_box-pagetabs']//h1[text() = 'Group Entry']")
    WebElementFacade groupEntryHeaderH1;

    @FindBy(xpath = "//input[@name = 'GROUP_CONTROL_GROUP_BU']")
    WebElementFacade groupUnitInput;

    @FindBy(xpath = "//input[@value = 'Add']")
    WebElementFacade addBtnInput;

    @FindBy(xpath = "//a[@aria-label = 'Group Control']|//a[.//*[text() = 'Group Control']]")
    WebElementFacade groupControlAnchor;

    @FindBy(xpath = "//input[@id = 'GROUP_CONTROL_GROUP_TYPE']")
    WebElementFacade groupTypeInput;

    @FindBy(xpath = "//input[@id = 'GROUP_CONTROL_ORIGIN_ID']")
    WebElementFacade originIDInput;

    @FindBy(xpath = "//input[@id = 'GROUP_CONTROL_CONTROL_CURRENCY']")
    WebElementFacade currencyControlInput;

    @FindBy(xpath = "//input[@id = 'GROUP_CONTROL_CONTROL_AMT']")
    WebElementFacade controlTotalsControlInput;

    @FindBy(xpath = "//a[@aria-label = 'Pending Item 1']|//a[.//*[text() = 'Pending Item 1']]")
    WebElementFacade pendingItem1Anchor;

    @FindBy(xpath = "//a[@aria-label = 'Pending Item 3']|//a[.//*[text() = 'Pending Item 3']]")
    WebElementFacade pendingItem3Anchor;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_BUSINESS_UNIT$0']")
    WebElementFacade pendingItemBusinessUnitInput;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_CUST_ID$0']")
    WebElementFacade pendingItemCustomerInput;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_ITEM_LINE$0']")
    WebElementFacade pendingItemLineInput;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_PYMNT_TERMS_CD$48$$0']")
    WebElementFacade pendingItemTermsInput;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_ENTRY_AMT$0']")
    WebElementFacade pendingItemAmountInput;

    @FindBy(xpath = "//select[@id = 'PENDING_ITEM_ENTRY_TYPE$0']")
    WebElementFacade pendingItemEntryTypeSelect;

    @FindBy(xpath = "//input[@id = 'PENDING_ITEM_ENTRY_REASON$0']")
    WebElementFacade pendingItemEntryReason;

    @FindBy(xpath = "//a[@aria-label = 'Group Action']|//a[.//*[text() = 'Group Action']]")
    WebElementFacade groupActionAnchor;

    @FindBy(xpath = "//input[@id = 'BALANCE_WRK_GRP_BALANCE$13$']")
    WebElementFacade groupActionsBalanceInput;

    @FindBy(xpath = "//input[@id = 'GROUP_CONTROL_CONTROL_CNT']")
    WebElementFacade controlToolsCountInput;

    @FindBy(xpath = "//input[@id = 'BALANCE_WRK_CREATE_ALL_DST_LNS$18$']")
    WebElementFacade accountingEntryActionsCreateEntriesInput;

    @FindBy(xpath = "//a[@aria-label = 'Accounting Entries']|//a[.//*[text() = 'Accounting Entries']]")
    WebElementFacade accountingEntriesAnchor;

    @FindBy(xpath = "//a[@id = 'ICTAB_HIDE_71']")
    WebElementFacade distributionLinesShowAllColumnsAnchor;

    @FindBy(xpath = "//input[@id = '#ICSave']")
    WebElementFacade accountingEntriesSaveInput;

    @FindBy(xpath = "//select[@id = 'REALTIME_WRK_RTM_PROCESS_LIST']")
    WebElementFacade postingActionActionSelect;

    @FindBy(xpath = "//input[@id = 'REALTIME_WRK_RTM_RUN']")
    WebElementFacade postingActionOkInput;

    @FindBy(xpath = "//span[@id = 'PSXLATITEM_XLATLONGNAME']")
    WebElementFacade groupActionStatusSpan;

    @FindBy(xpath = "//input[@id = '#ICAdd']")
    WebElementFacade accountingEntriesAddInput;

    @FindBy(xpath = "//select[@id = 'GRP_ENT_ONL_VW_GROUP_BU$op']")
    WebElementFacade setSearchCriteriaGroupUnitSelect;

    @FindBy(xpath = "//input[@id = 'GRP_ENT_ONL_VW_GROUP_BU']")
    WebElementFacade searchCriteriaGroupUnitInput;

    @FindBy(xpath = "//input[@id = 'GRP_ENT_ONL_VW_ORIG_OPRID']")
    WebElementFacade searchCriteriaUserIDInput;

    @FindBy(xpath = "//input[@id = 'GRP_ENT_ONL_VW_ENTRY_DT']")
    WebElementFacade searchCriteriaEnteredDateInput;

    @FindBy(xpath = "//input[@id = '#ICSearch']")
    WebElementFacade searchCriteriaSearchInput;

    @FindBy(xpath = "//input[@id = '#ICOK']")
    WebElementFacade okInput;

    @FindBy(xpath = "//input[@id = 'GRP_ENT_ONL_VW_GROUP_ID']")
    WebElementFacade searchCriteriaGroupIDInput;

    @FindBy(xpath = "//span[@id = 'GROUP_CONTROL_GROUP_ID']")
    WebElementFacade groupControlGroupIDSpan;

    @FindBy(xpath = "//input[contains(@class, 'PSPUSHBUTTONTBRETURN')]")
    WebElementFacade returnToSearchInput;

    final String SAVED_GROUP_ID = "GroupEntryPage::Saved_Group_ID";


    public void clickAddANewValueBtn () {

        clickElement(addANewValue);
        waitForLoadingSpinner();

    }

    public void clickFindAnExistingValueBtn() {
        clickElement(findAnExistingValue);
    }

    public boolean isGroupEntryHeaderVisible () {

        ExplicitWait.explicitlyWaitForPresenceOfElementIgnoreException(getDriver(), 30, groupEntryHeaderH1);
        boolean isVisible = false;
        if (groupEntryHeaderH1.isPresent()) {
            isVisible = groupEntryHeaderH1.isVisible();
        }

        return isVisible;
    }

    public void setGroupUnit(String group_unit) {

        typeAndSelectSearchResultFromPopUp(groupUnitInput, group_unit, false);
        waitForLoadingSpinner();

    }

    public void clickAddBtn() {

        clickElement(addBtnInput);
        waitForLoadingSpinner();

    }

    public boolean isGroupControlHeaderSelected () {

        boolean isSelected = groupControlAnchor.getAttribute("aria-selected").equals("true");

        return isSelected;
    }

    public void setGroupType(String group_type) {

        typeAndSelectSearchResultFromPopUp(groupTypeInput, group_type, false);
        waitForLoadingSpinner();

    }

    public void setOriginID(String origin_id) {

        typeIntoInput(originIDInput, origin_id);

    }

    public void setCurrencyControl(String currency_control) {

        typeIntoInput(currencyControlInput, currency_control, false);

    }

    public void setControlTotalsControl(String control_tools_control) {

        typeIntoInput(controlTotalsControlInput, control_tools_control);

    }

    public void clickPendingItem1() {

        waitForLoadingSpinner();
        clickElement(pendingItem1Anchor);
        waitForLoadingSpinner();

    }

    public boolean isPendingItem1HeaderSelected() {

        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 40, pendingItem1Anchor);
        boolean isSelected = pendingItem1Anchor.getAttribute("aria-selected").equals("true");

        return isSelected;
    }

    public void setPendingItemBusinessUnit(String business_unit) {

        typeAndSelectSearchResultFromPopUp(pendingItemBusinessUnitInput, business_unit);

    }

    public void setPendingItemCustomer(String customer) {

        typeAndSelectSearchResultFromPopUp(pendingItemCustomerInput, customer);

    }

    public void setPendingItemLine(String line) {

        typeIntoInput(pendingItemLineInput, line);
        waitForLoadingSpinner();

    }

    public void setPedingItemTerms(String terms) {

        typeAndSelectSearchResultFromPopUp(pendingItemTermsInput, terms);

    }

    public void setPendingItemAmount(String amount) {

        typeIntoInput(pendingItemAmountInput, amount);

    }

    public void setPendingItemEntryType(String entry_type) {

        selectFromOption(pendingItemEntryTypeSelect, entry_type, null, false);

    }

    public void setPendingItemReason(String reason) {

        typeIntoInput(pendingItemEntryReason, reason);

    }

    public void clickPendingItem3() {

        waitForLoadingSpinner();
        clickElement(pendingItem3Anchor);
        waitForLoadingSpinner();

    }

    public boolean isPendingItem3HeaderSelected() {

        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 40, pendingItem3Anchor);
        boolean isSelected = pendingItem3Anchor.getAttribute("aria-selected").equals("true");

        return isSelected;
    }

    public void setUserText(int i, String user_text) {

        ExplicitWait.explicitlyWaitForNumberOfElementsToBeMoreThan(getDriver(), 20, Selectors.USER_TEXT_INPUTS.getBy(), 9);
        typeIntoInput(findAll(Selectors.USER_TEXT_INPUTS.getBy()).get(i - 1), user_text);

    }

    public void clickGroupAction() {

        waitForLoadingSpinner();
        clickElement(groupActionAnchor);
        waitForLoadingSpinner();

    }

    public boolean isGroupActionHeaderSelected() {

        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 40, groupActionAnchor);
        boolean isSelected = groupActionAnchor.getAttribute("aria-selected").equals("true");

        return isSelected;
    }

    public void clickGroupActionsBalanceBtn() {

        waitForLoadingSpinner();
        clickElement(groupActionsBalanceInput);
        waitForLoadingSpinner();

    }

    public void setControlTotalsCount(String control_tools_count) {

        typeIntoInput(controlToolsCountInput, control_tools_count);

    }

    public void clickAccountingEntryActionsCreateEntries() {

        waitForLoadingSpinner();
        clickElement(accountingEntryActionsCreateEntriesInput);
        waitForLoadingSpinner();

    }

    public boolean isAccountingEntriesHeaderSelected() {
        ExplicitWait.explicitlyWaitForElementToBeClickable(getDriver(), 40, accountingEntriesAnchor);
        boolean isSelected = accountingEntriesAnchor.getAttribute("aria-selected").equals("true");
        return isSelected;
    }

    public void clickDistributionLinesShowAllColumnsButton() {
        waitForLoadingSpinner();
        clickElement(distributionLinesShowAllColumnsAnchor);
        waitForLoadingSpinner();
    }

    public void setDistributionLineRowColumnValue(int rowIndex, String column, String value, boolean search) {
        int leftHeaderIndex = getDistributionLinesHeaderColumnIndex(column, true);
        int rightHeaderIndex = getDistributionLinesHeaderColumnIndex(column, false);

        int headerIndex = leftHeaderIndex == -1 ? rightHeaderIndex : leftHeaderIndex;

        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElementFacade table;
                if (leftHeaderIndex == -1) {
                    ExplicitWait.explicitlyWaitForVisibilityOfAllElements(getDriver(), 10, Selectors.DISTRIBUTION_LINES_RIGHT_TABLE.getBy());
                    table = find(Selectors.DISTRIBUTION_LINES_RIGHT_TABLE.getBy());
                } else {
                    ExplicitWait.explicitlyWaitForVisibilityOfAllElements(getDriver(), 10, Selectors.DISTRIBUTION_LINES_LEFT_TABLE.getBy());
                    table = find(Selectors.DISTRIBUTION_LINES_LEFT_TABLE.getBy());
                }
                WebElementFacade tableRow = table.thenFindAll(By.xpath(".//tr")).get(rowIndex);
                WebElementFacade rowData = tableRow.thenFindAll(By.xpath(".//td")).get(headerIndex);
                WebElementFacade input = rowData.find(By.xpath(".//input"));
                ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 10, input);
                if (search) {
                    typeAndSelectSearchResultFromPopUp(input, value);
                } else {
                    typeIntoInput(input, value);
                }
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element exception thrown! Retrying....");
            }
            attempts++;
        }
        waitForLoadingSpinner();

    }

    public void setDistributionLineRowObjective(int rowIndex, String objective) {
        setDistributionLineRowColumnValue(rowIndex, "Objective", objective, true);
    }

    private int getDistributionLinesHeaderColumnIndex (String headerName, boolean left) {
        List<WebElementFacade> tableHeaderCells;
        if (left) {
            ExplicitWait.explicitlyWaitForVisibilityOfAllElements(getDriver(), 10, Selectors.DISTRIBUTION_LINES_LEFT_TABLE_HEADER_CELLS.getBy());
            tableHeaderCells = findAll(Selectors.DISTRIBUTION_LINES_LEFT_TABLE_HEADER_CELLS.getBy());
        } else {
            ExplicitWait.explicitlyWaitForVisibilityOfAllElements(getDriver(), 10, Selectors.DISTRIBUTION_LINES_RIGHT_TABLE_HEADER_CELLS.getBy());
            tableHeaderCells = findAll(Selectors.DISTRIBUTION_LINES_RIGHT_TABLE_HEADER_CELLS.getBy());
        }

        int index = 0;
        boolean found = false;
        for (WebElementFacade tableHeaderCell : tableHeaderCells) {
            System.out.println("==========> " + tableHeaderCell.getText());
            if (tableHeaderCell.getText().trim().toLowerCase().equalsIgnoreCase(headerName.toLowerCase())) {
                found = true;
                break;
            }
            index++;
        }
        System.out.println("==========> " + index);
        if (found) {
            return index;
        }
        return -1;
    }

    public void setDistributionLineRowOU(int rowIndex, String ou) {
        setDistributionLineRowColumnValue(rowIndex, "OU", ou, true);
    }

    public void setDistributionLineRowLinesDescr(int rowIndex, String line_descr) {
        setDistributionLineRowColumnValue(rowIndex, "Line Descr", line_descr, false);
    }

    public void clickAccountingEntriesSaveBtn () {

        waitForLoadingSpinner();
        clickElement(accountingEntriesSaveInput);
        waitForLoadingSpinner();

    }

    public void setPostingActionAction(String action) {

        waitForLoadingSpinner();
        selectFromOption(postingActionActionSelect, action, groupActionStatusSpan.getText().trim(), true);
        waitForLoadingSpinner();

    }

    public void clickPostingActionOkBtn() {

        waitForLoadingSpinner();
        clickElement(postingActionOkInput);
        waitForLoadingSpinner();

    }

    public void clickAccountingEntries() {

        waitForLoadingSpinner();
        clickElement(accountingEntriesAnchor);
        waitForLoadingSpinner();

    }

    public void clickAccountingEntriesAddBtn() {

        waitForLoadingSpinner();
        clickElement(accountingEntriesAddInput);
        waitForLoadingSpinner();

    }

    public void setDistributionLineRowLinesAccount(int rowIndex, String account) {
        setDistributionLineRowColumnValue(rowIndex, "*Account", account, true);
    }

    public void setSearchCriteriaGroupUnitDropdown(String group_unit_dropdown_search_criteria) {

        selectFromOption(setSearchCriteriaGroupUnitSelect, group_unit_dropdown_search_criteria, null, false);

    }

    public void setSearchCriteriaGroupUnit(String search_criteria_group_unit) {

        typeIntoInput(searchCriteriaGroupUnitInput, search_criteria_group_unit);

    }

    public void setSearchCriteriaUserID(String search_criteria_user_id) {

        typeAndSelectSearchResultFromPopUp(searchCriteriaUserIDInput, search_criteria_user_id);

    }

    public void setSearchCriteriaEnteredDate(String search_criteria_entered_date) {

        typeIntoInput(searchCriteriaEnteredDateInput, search_criteria_entered_date);

    }

    public void clickSearchCriteriaSearchBtn() {

        waitForLoadingSpinner();
        clickElement(searchCriteriaSearchInput);
        waitForLoadingSpinner();

    }

    public void clickMessageDialogBoxOkBtn() {

        waitForLoadingSpinner();
        ExplicitWait.explicitlyWaitForElementToBeClickableIgnoreException(getDriver(), 5, okInput);
        if (okInput.isPresent()) {
            clickElement(okInput);
            waitForLoadingSpinner();
        }

    }

    public String getSavedGroupID(int groupIDNumber) {
        System.out.println("SAVED GROUP ID ==> " + Serenity.sessionVariableCalled(SAVED_GROUP_ID));
        return ((List<String>) Serenity.sessionVariableCalled(SAVED_GROUP_ID)).get(groupIDNumber);
    }

    public void setSearchCriteriaGroupID(String savedGroupID) {
        typeIntoInput(searchCriteriaGroupIDInput, savedGroupID);
    }

    public String getGroupControlGroupID () {
        ExplicitWait.explicitlyWaitForVisibilityOfElement(getDriver(), 10, groupControlGroupIDSpan);
        String groupID = groupControlGroupIDSpan.getText();
        return groupID;
    }

    public void saveGroupID() {
        String groupID = getGroupControlGroupID();
        List<String> savedGroupIDs = Serenity.sessionVariableCalled(SAVED_GROUP_ID) == null ? new ArrayList<>() : Serenity.sessionVariableCalled(SAVED_GROUP_ID);
        savedGroupIDs.add(groupID);
        Serenity.setSessionVariable(SAVED_GROUP_ID).to(savedGroupIDs);
    }

    public void clickGroupControlBtn() {
        waitForLoadingSpinner();
        clickElement(groupControlAnchor);
        waitForLoadingSpinner();
    }

    public void clickOnReturnToSearchBtn() {
        waitForLoadingSpinner();
        clickElement(returnToSearchInput);
        waitForLoadingSpinner();
    }
}
