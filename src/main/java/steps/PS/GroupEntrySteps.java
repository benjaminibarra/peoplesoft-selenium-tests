package steps.PS;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageObjects.PS.GroupEntryPage;

public class GroupEntrySteps extends GenericSteps {

    @ManagedPages
    GroupEntryPage groupEntryPage;

    @Step
    public void switch_to_Pt_IFrame () {
        groupEntryPage.switchToPtIFrame();
    }

    @Step
    public void switch_to_Base_DOM () {
        groupEntryPage.switchToBaseDom();
    }

    @Step
    public void when_I_open_the_Group_entry_menu () {
        when_I_open_a_menu("Accounts Receivable", "Pending Items", "Online Items", "Group Entry");
    }

    @Step
    public void when_I_click_Add_a_New_Value_button() {
        groupEntryPage.clickAddANewValueBtn();
    }

    @Step
    public void then_the_Group_Entry_page_and_its_contents_should_show_up() {
        Assert.assertTrue(groupEntryPage.isGroupEntryHeaderVisible());
    }

    @Step
    public void when_I_set_the_Group_Unit_to(String group_unit) {
        groupEntryPage.setGroupUnit(group_unit);
    }

    @Step
    public void when_I_click_on_Add_button() {
        groupEntryPage.clickAddBtn();
    }

    @Step
    public void then_the_Group_Control_form_should_show_up() {
        Assert.assertTrue(groupEntryPage.isGroupControlHeaderSelected());
        //groupEntryPage.saveGroupID();
    }

    @Step
    public void when_I_set_the_Group_Type(String group_type) {
        groupEntryPage.setGroupType(group_type);
    }

    @Step
    public void when_I_set_the_Origin_ID(String origin_id) {
        groupEntryPage.setOriginID(origin_id);
    }

    @Step
    public void when_I_set_the_Currency_Control(String currency_control) {
        groupEntryPage.setCurrencyControl(currency_control);
    }

    @Step
    public void when_I_set_the_Control_Totals_Control(String control_tools_control) {
        groupEntryPage.setControlTotalsControl(control_tools_control);
    }

    @Step
    public void when_I_click_on_Pending_Item_1_form_header() {
        groupEntryPage.clickPendingItem1();
    }

    @Step
    public void then_the_Pending_Item_1_form_should_show_up() {
        Assert.assertTrue(groupEntryPage.isPendingItem1HeaderSelected());
    }

    @Step
    public void when_I_set_the_Pending_Item_Entry_Business_Unit(String business_unit) {
        groupEntryPage.setPendingItemBusinessUnit(business_unit);
    }

    @Step
    public void when_I_set_the_Pending_Item_Entry_Customer(String customer) {
        groupEntryPage.setPendingItemCustomer(customer);
    }

    @Step
    public void when_I_set_the_Pending_Item_Line(String line) {
        groupEntryPage.setPendingItemLine(line);
    }

    @Step
    public void when_I_set_the_Pending_Item_Terms(String terms) {
        groupEntryPage.setPedingItemTerms(terms);
    }

    @Step
    public void when_I_set_the_Pending_Item_Amount(String amount) {
        groupEntryPage.setPendingItemAmount(amount);
    }

    @Step
    public void when_I_set_the_Pending_Item_Entry_Type(String entry_type) {
        groupEntryPage.setPendingItemEntryType(entry_type);
    }

    @Step
    public void when_I_set_the_Reason(String reason) {
        groupEntryPage.setPendingItemReason(reason);
    }

    @Step
    public void when_I_click_on_Pending_Item_3_form_header() {
        groupEntryPage.clickPendingItem3();
    }

    @Step
    public void then_the_Pending_Item_3_form_should_show_up() {
        Assert.assertTrue(groupEntryPage.isPendingItem3HeaderSelected());
    }

    @Step
    public void when_I_set_the_User_Text_1(String user_text_1) {
        groupEntryPage.setUserText(1, user_text_1);
    }

    @Step
    public void when_I_click_on_Group_Action_form_header() {
        groupEntryPage.clickGroupAction();
    }

    @Step
    public void then_the_Group_Action_form_should_show_up() {
        Assert.assertTrue(groupEntryPage.isGroupActionHeaderSelected());
    }

    @Step
    public void when_I_click_on_Group_Actions_Balance_button() {
        groupEntryPage.clickGroupActionsBalanceBtn();
    }

    @Step
    public void when_I_set_the_Control_Totals_Count(String control_tools_count) {
        groupEntryPage.setControlTotalsCount(control_tools_count);
    }

    @Step
    public void when_I_click_on_Create_Entries_button() {
        groupEntryPage.clickAccountingEntryActionsCreateEntries();
    }

    @Step
    public void then_the_Accounting_Entries_form_should_show_up() {
        Assert.assertTrue(groupEntryPage.isAccountingEntriesHeaderSelected());
    }

    @Step
    public void when_I_click_on_Show_All_Columns_button() {
        groupEntryPage.clickDistributionLinesShowAllColumnsButton();
    }

    @Step
    public void when_I_set_the_Objective_of_the_first_Distribution_Lines_row(String objective) {
        groupEntryPage.setDistributionLineRowObjective(0, objective);
    }

    @Step
    public void when_I_set_the_Objective_of_the_second_Distribution_Lines_row(String objective) {
        groupEntryPage.setDistributionLineRowObjective(1, objective);
    }

    @Step
    public void when_I_set_the_OU_of_the_first_Distribution_Lines_row(String ou) {
        groupEntryPage.setDistributionLineRowOU(0, ou);
    }

    @Step
    public void when_I_set_the_OU_of_the_second_Distribution_Lines_row(String ou) {
        groupEntryPage.setDistributionLineRowOU(1, ou);
    }

    @Step
    public void when_I_set_the_Line_Descr_of_the_first_Distribution_Lines_row(String line_descr) {
        groupEntryPage.setDistributionLineRowLinesDescr(0, line_descr);
    }

    @Step
    public void when_I_set_the_Line_Descr_of_the_second_Distribution_Lines_row(String line_descr) {
        groupEntryPage.setDistributionLineRowLinesDescr(1, line_descr);
    }

    @Step
    public void when_I_click_on_Accounting_Entries_Save_button() {
        groupEntryPage.clickAccountingEntriesSaveBtn();
        groupEntryPage.waitForSavedPopup();
    }

    @Step
    public void when_I_set_the_Posting_Action_Action(String action) {
        groupEntryPage.setPostingActionAction(action);
    }

    @Step
    public void when_I_click_on_Posting_Action_Ok_button() {
        groupEntryPage.saveGroupID();
        groupEntryPage.clickPostingActionOkBtn();
    }

    @Step
    public void when_I_click_on_Accounting_Entries_form_header() {
        groupEntryPage.clickAccountingEntries();
    }

    @Step
    public void when_I_click_on_AccountingEntries_Add_button() {
        groupEntryPage.clickAccountingEntriesAddBtn();
    }

    @Step
    public void when_I_set_the_Account_of_the_second_Distribution_Lines_row(String account) {
        groupEntryPage.setDistributionLineRowLinesAccount(1, account);
    }

    @Step
    public void when_I_set_the_Account_of_the_first_Distribution_Lines_row(String account) {
        groupEntryPage.setDistributionLineRowLinesAccount(0, account);
    }

    @Step
    public void when_I_click_Find_an_Existing_Value_button() {
        groupEntryPage.waitForLoadingSpinner();
        groupEntryPage.clickFindAnExistingValueBtn();
        groupEntryPage.waitForLoadingSpinner();
    }

    @Step
    public void when_I_set_Search_Criteria_Group_Unit_Dropdown(String group_unit_dropdown_search_criteria) {
        groupEntryPage.setSearchCriteriaGroupUnitDropdown(group_unit_dropdown_search_criteria);
    }

    @Step
    public void when_I_set_Search_Criteria_Group_Unit(String search_criteria_group_unit) {
        groupEntryPage.setSearchCriteriaGroupUnit(search_criteria_group_unit);
    }

    @Step
    public void when_I_set_Search_Criteria_User_ID(String search_criteria_user_id) {
        groupEntryPage.setSearchCriteriaUserID(search_criteria_user_id);
    }

    @Step
    public void when_I_set_Search_Criteria_Entered_Date(String search_criteria_entered_date) {
        groupEntryPage.setSearchCriteriaEnteredDate(search_criteria_entered_date);
    }

    @Step
    public void when_I_click_Search_Creteria_Search_Button() {
        groupEntryPage.clickSearchCriteriaSearchBtn();
    }

    @Step
    public void when_I_click_Ok_on_the_Message_Dialog_box() {
        groupEntryPage.clickMessageDialogBoxOkBtn();
    }

    @Step
    public void when_I_set_Search_Criteria_Group_ID_using_saved_Group_ID_1() {
        groupEntryPage.setSearchCriteriaGroupID(groupEntryPage.getSavedGroupID(0));
    }

    @Step
    public void when_I_set_Search_Criteria_Group_ID_using_saved_Group_ID_2() {
        groupEntryPage.setSearchCriteriaGroupID(groupEntryPage.getSavedGroupID(1));
    }

    @Step
    public void then_the_Group_Control_page_for_Group_ID_1_should_show_up() {
        Assert.assertEquals(groupEntryPage.getSavedGroupID(0), groupEntryPage.getGroupControlGroupID());
    }

    @Step
    public void when_I_click_on_Return_to_Search_button() {
        groupEntryPage.clickOnReturnToSearchBtn();
    }

    @Step
    public void then_the_Group_Control_page_for_Group_ID_2_should_show_up() {
        Assert.assertEquals(groupEntryPage.getSavedGroupID(1), groupEntryPage.getGroupControlGroupID());
    }
}
