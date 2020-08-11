package org.icrc.peoplesoft.PS.AccountsRecievable;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PS.GroupEntrySteps;
import steps.PS.LoginSteps;
import utils.TestData;

@RunWith(SerenityRunner.class)
public class MaintenanceWorksheetAndUnpost {

    @Managed
    WebDriver webDriver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    GroupEntrySteps groupEntrySteps;

    TestData manualMaintenanceWorksheetTestData = new TestData("manualMaintenanceWorksheet");

    @Test
    public void manualMaintenanceWorksheet () {

        //=========================Item 1============================
        String GROUP_UNIT_1 = manualMaintenanceWorksheetTestData.getString("GROUP_UNIT_1");
        String GROUP_TYPE_1 = manualMaintenanceWorksheetTestData.getString("GROUP_TYPE_1");
        String ORIGIN_ID_1 = manualMaintenanceWorksheetTestData.getString("ORIGIN_ID_1");
        String CURRENCY_CONTROL_1 = manualMaintenanceWorksheetTestData.getString("CURRENCY_CONTROL_1");
        String CONTROL_TOOLS_CONTROL_1 = manualMaintenanceWorksheetTestData.getString("CONTROL_TOOLS_CONTROL_1");
        String CONTROL_TOOLS_COUNT_1 = manualMaintenanceWorksheetTestData.getString("CONTROL_TOOLS_COUNT_1");

        String BUSINESS_UNIT_1 = manualMaintenanceWorksheetTestData.getString("BUSINESS_UNIT_1");
        String CUSTOMER_1 = manualMaintenanceWorksheetTestData.getString("CUSTOMER_1");
        String LINE_1 = manualMaintenanceWorksheetTestData.getString("LINE_1");
        String TERMS_1 = manualMaintenanceWorksheetTestData.getString("TERMS_1");
        String AMOUNT_1 = manualMaintenanceWorksheetTestData.getString("AMOUNT_1");
        String ENTRY_TYPE_1 = manualMaintenanceWorksheetTestData.getString("ENTRY_TYPE_1");
        String REASON_1 = manualMaintenanceWorksheetTestData.getString("REASON_1");

        String USER_TEXT_1_1 = manualMaintenanceWorksheetTestData.getString("USER_TEXT_1_1");

        String OBJECTIVE_1_1 = manualMaintenanceWorksheetTestData.getString("OBJECTIVE_1_1");
        String OBJECTIVE_2_1 = manualMaintenanceWorksheetTestData.getString("OBJECTIVE_2_1");
        String OU_1_1 = manualMaintenanceWorksheetTestData.getString("OU_1_1");
        String OU_2_1 = manualMaintenanceWorksheetTestData.getString("OU_2_1");
        String LINE_DESCR_1_1 = manualMaintenanceWorksheetTestData.getString("LINE_DESCR_1_1");
        String LINE_DESCR_2_1 = manualMaintenanceWorksheetTestData.getString("LINE_DESCR_2_1");

        String POSTING_ACTION_ACTION_1 = manualMaintenanceWorksheetTestData.getString("POSTING_ACTION_ACTION_1");

        //=========================Item 2============================
        String GROUP_UNIT_2 = manualMaintenanceWorksheetTestData.getString("GROUP_UNIT_2");
        String GROUP_TYPE_2 = manualMaintenanceWorksheetTestData.getString("GROUP_TYPE_2");
        String ORIGIN_ID_2 = manualMaintenanceWorksheetTestData.getString("ORIGIN_ID_2");
        String CURRENCY_CONTROL_2 = manualMaintenanceWorksheetTestData.getString("CURRENCY_CONTROL_2");
        String CONTROL_TOOLS_CONTROL_2 = manualMaintenanceWorksheetTestData.getString("CONTROL_TOOLS_CONTROL_2");
        String CONTROL_TOOLS_COUNT_2 = manualMaintenanceWorksheetTestData.getString("CONTROL_TOOLS_COUNT_2");

        String BUSINESS_UNIT_2 = manualMaintenanceWorksheetTestData.getString("BUSINESS_UNIT_2");
        String CUSTOMER_2 = manualMaintenanceWorksheetTestData.getString("CUSTOMER_2");
        String LINE_2 = manualMaintenanceWorksheetTestData.getString("LINE_2");
        String TERMS_2 = manualMaintenanceWorksheetTestData.getString("TERMS_2");
        String AMOUNT_2 = manualMaintenanceWorksheetTestData.getString("AMOUNT_2");
        String ENTRY_TYPE_2 = manualMaintenanceWorksheetTestData.getString("ENTRY_TYPE_2");
        String REASON_2 = manualMaintenanceWorksheetTestData.getString("REASON_2");

        String USER_TEXT_1_2 = manualMaintenanceWorksheetTestData.getString("USER_TEXT_1_2");
        String LINE_DESCR_1_2 = manualMaintenanceWorksheetTestData.getString("LINE_DESCR_1_2");

        String OBJECTIVE_2_2 = manualMaintenanceWorksheetTestData.getString("OBJECTIVE_2_2");
        String OU_2_2 = manualMaintenanceWorksheetTestData.getString("OU_2_2");
        String LINE_DESCR_2_2 = manualMaintenanceWorksheetTestData.getString("LINE_DESCR_2_2");
        String ACCOUNT_1 = manualMaintenanceWorksheetTestData.getString("ACCOUNT_1");

        String POSTING_ACTION_ACTION_2 = manualMaintenanceWorksheetTestData.getString("POSTING_ACTION_ACTION_2");

        //========================= Item Search ============================
        String SEARCH_CRITERIA_GROUP_UNIT_DROPDOWN = manualMaintenanceWorksheetTestData.getString("SEARCH_CRITERIA_GROUP_UNIT_DROPDOWN");
        String SEARCH_CRITERIA_GROUP_UNIT =manualMaintenanceWorksheetTestData.getString("SEARCH_CRITERIA_GROUP_UNIT");

//        //=========================Item 1============================
//        String GROUP_UNIT_1 = "ARFIN";
//        String GROUP_TYPE_1 = "B";
//        String ORIGIN_ID_1 = "OBILL";
//        String CURRENCY_CONTROL_1 = "chf";
//        String CONTROL_TOOLS_CONTROL_1 = "120";
//        String CONTROL_TOOLS_COUNT_1 = "1";
//
//        String BUSINESS_UNIT_1 = "ARFIN";
//        String CUSTOMER_1 = "PRV01817";
//        String LINE_1 = "1";
//        String TERMS_1 = "030";
//        String AMOUNT_1 = "120";
//        String ENTRY_TYPE_1 = "IN";
//        String REASON_1 = "VARIO";
//
//        String USER_TEXT_1_1 = "TEST 1";
//
//        String OBJECTIVE_1_1 = "NO";
//        String OBJECTIVE_2_1 = "NO";
//        String OU_1_1 = "ILOT";
//        String OU_2_1 = "ILOT";
//        String LINE_DESCR_1_1 = "test description 1";
//        String LINE_DESCR_2_1 = "test description 1";
//
//        String POSTING_ACTION_ACTION_1 = "Batch Standard";
//
//        //=========================Item 2============================
//        String GROUP_UNIT_2 = "ARFIN";
//        String GROUP_TYPE_2 = "C";
//        String ORIGIN_ID_2 = "OCRED";
//        String CURRENCY_CONTROL_2 = "chf";
//        String CONTROL_TOOLS_CONTROL_2 = "-120";
//        String CONTROL_TOOLS_COUNT_2 = "1";
//
//        String BUSINESS_UNIT_2 = "ARFIN";
//        String CUSTOMER_2 = "PRV01817";
//        String LINE_2 = "1";
//        String TERMS_2 = "000";
//        String AMOUNT_2 = "-120";
//        String ENTRY_TYPE_2 = "CR";
//        String REASON_2 = "MATCH";
//
//        String USER_TEXT_1_2 = "TEST CREDIT NO";
//        String LINE_DESCR_1_2 = "test credit note description 1";
//
//        String OBJECTIVE_2_2 = "NO";
//        String OU_2_2 = "ILOT";
//        String LINE_DESCR_2_2 = "test credit note description 1";
//        String ACCOUNT_1 = "985000";
//
//        String POSTING_ACTION_ACTION_2 = "Batch Standard";
//
//        //========================= Item Search ============================
//
//        String SEARCH_CRITERIA_GROUP_UNIT_DROPDOWN = "in";
//        String SEARCH_CRITERIA_GROUP_UNIT = "ARFIN";
//        SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
//        String CURRENT_DATE = formatter.format(new Date());


        loginSteps.given_that_im_logged_in_to_PeopleSoft_page();

        groupEntrySteps.when_I_open_the_Group_entry_menu();

        groupEntrySteps.switch_to_Pt_IFrame();

        groupEntrySteps.then_the_Group_Entry_page_and_its_contents_should_show_up();

        groupEntrySteps.when_I_click_Add_a_New_Value_button();

        //=====================================Item 1=================================

        groupEntrySteps.when_I_set_the_Group_Unit_to(GROUP_UNIT_1);

        groupEntrySteps.when_I_click_on_Add_button();

        groupEntrySteps.then_the_Group_Control_form_should_show_up();

        groupEntrySteps.when_I_set_the_Group_Type(GROUP_TYPE_1);

        groupEntrySteps.when_I_set_the_Origin_ID(ORIGIN_ID_1);

        groupEntrySteps.when_I_set_the_Currency_Control(CURRENCY_CONTROL_1);

        groupEntrySteps.when_I_set_the_Control_Totals_Control(CONTROL_TOOLS_CONTROL_1);

        groupEntrySteps.when_I_set_the_Control_Totals_Count(CONTROL_TOOLS_COUNT_1);

        groupEntrySteps.when_I_click_on_Pending_Item_1_form_header();

        groupEntrySteps.then_the_Pending_Item_1_form_should_show_up();

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Business_Unit(BUSINESS_UNIT_1);

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Type(ENTRY_TYPE_1);

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Customer(CUSTOMER_1);

        groupEntrySteps.when_I_set_the_Pending_Item_Line(LINE_1);

        groupEntrySteps.when_I_set_the_Pending_Item_Terms(TERMS_1);

        groupEntrySteps.when_I_set_the_Pending_Item_Amount(AMOUNT_1);

        groupEntrySteps.when_I_set_the_Reason(REASON_1);

        groupEntrySteps.when_I_click_on_Pending_Item_3_form_header();

        groupEntrySteps.then_the_Pending_Item_3_form_should_show_up();

        groupEntrySteps.when_I_set_the_User_Text_1(USER_TEXT_1_1);

        groupEntrySteps.when_I_click_on_Group_Action_form_header();

        groupEntrySteps.then_the_Group_Action_form_should_show_up();

        groupEntrySteps.when_I_click_on_Group_Actions_Balance_button();

        groupEntrySteps.when_I_click_on_Create_Entries_button();

        groupEntrySteps.then_the_Accounting_Entries_form_should_show_up();

        groupEntrySteps.when_I_click_on_Show_All_Columns_button();

        groupEntrySteps.when_I_set_the_Objective_of_the_first_Distribution_Lines_row(OBJECTIVE_1_1);

        groupEntrySteps.when_I_set_the_OU_of_the_first_Distribution_Lines_row(OU_1_1);

        groupEntrySteps.when_I_set_the_Line_Descr_of_the_first_Distribution_Lines_row(LINE_DESCR_1_1);

        groupEntrySteps.when_I_set_the_Objective_of_the_second_Distribution_Lines_row(OBJECTIVE_2_1);

        groupEntrySteps.when_I_set_the_OU_of_the_second_Distribution_Lines_row(OU_2_1);

        groupEntrySteps.when_I_set_the_Line_Descr_of_the_second_Distribution_Lines_row(LINE_DESCR_2_1);

        groupEntrySteps.when_I_click_on_Accounting_Entries_Save_button();

        groupEntrySteps.when_I_click_on_Group_Action_form_header();

        groupEntrySteps.then_the_Group_Action_form_should_show_up();

        groupEntrySteps.when_I_set_the_Posting_Action_Action(POSTING_ACTION_ACTION_1);

        groupEntrySteps.when_I_click_on_Posting_Action_Ok_button();

        groupEntrySteps.when_I_click_on_Accounting_Entries_form_header();

        groupEntrySteps.when_I_click_on_AccountingEntries_Add_button();

        //=====================================Item 2=================================

        groupEntrySteps.then_the_Group_Entry_page_and_its_contents_should_show_up();

        groupEntrySteps.when_I_set_the_Group_Unit_to(GROUP_UNIT_2);

        groupEntrySteps.when_I_click_on_Add_button();

        groupEntrySteps.then_the_Group_Control_form_should_show_up();

        groupEntrySteps.when_I_set_the_Group_Type(GROUP_TYPE_2);

        groupEntrySteps.when_I_set_the_Origin_ID(ORIGIN_ID_2);

        groupEntrySteps.when_I_set_the_Currency_Control(CURRENCY_CONTROL_2);

        groupEntrySteps.when_I_set_the_Control_Totals_Control(CONTROL_TOOLS_CONTROL_2);

        groupEntrySteps.when_I_set_the_Control_Totals_Count(CONTROL_TOOLS_COUNT_2);

        groupEntrySteps.when_I_click_on_Pending_Item_1_form_header();

        groupEntrySteps.then_the_Pending_Item_1_form_should_show_up();

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Business_Unit(BUSINESS_UNIT_2);

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Type(ENTRY_TYPE_2);

        groupEntrySteps.when_I_set_the_Pending_Item_Entry_Customer(CUSTOMER_2);

        groupEntrySteps.when_I_set_the_Pending_Item_Line(LINE_2);

        groupEntrySteps.when_I_set_the_Pending_Item_Terms(TERMS_2);

        groupEntrySteps.when_I_set_the_Pending_Item_Amount(AMOUNT_2);

        groupEntrySteps.when_I_set_the_Reason(REASON_2);

        groupEntrySteps.when_I_click_on_Pending_Item_3_form_header();

        groupEntrySteps.then_the_Pending_Item_3_form_should_show_up();

        groupEntrySteps.when_I_set_the_User_Text_1(USER_TEXT_1_2);

        groupEntrySteps.when_I_click_on_Group_Action_form_header();

        groupEntrySteps.then_the_Group_Action_form_should_show_up();

        groupEntrySteps.when_I_click_on_Group_Actions_Balance_button();

        groupEntrySteps.when_I_click_on_Create_Entries_button();

        groupEntrySteps.then_the_Accounting_Entries_form_should_show_up();

        groupEntrySteps.when_I_click_on_Show_All_Columns_button();

        groupEntrySteps.when_I_set_the_Account_of_the_first_Distribution_Lines_row(ACCOUNT_1);

        groupEntrySteps.when_I_set_the_Line_Descr_of_the_first_Distribution_Lines_row(LINE_DESCR_1_2);

        groupEntrySteps.when_I_set_the_Objective_of_the_second_Distribution_Lines_row(OBJECTIVE_2_2);

        groupEntrySteps.when_I_set_the_OU_of_the_second_Distribution_Lines_row(OU_2_2);

        groupEntrySteps.when_I_set_the_Line_Descr_of_the_second_Distribution_Lines_row(LINE_DESCR_2_2);

        groupEntrySteps.when_I_click_on_Accounting_Entries_Save_button();

        groupEntrySteps.when_I_click_Ok_on_the_Message_Dialog_box();

        groupEntrySteps.when_I_click_on_Group_Action_form_header();

        groupEntrySteps.then_the_Group_Action_form_should_show_up();

        groupEntrySteps.when_I_set_the_Posting_Action_Action(POSTING_ACTION_ACTION_2);

        groupEntrySteps.when_I_click_on_Posting_Action_Ok_button();

        groupEntrySteps.when_I_click_on_Accounting_Entries_form_header();

        groupEntrySteps.when_I_click_on_AccountingEntries_Add_button();

        //=====================================Item Search=================================

        groupEntrySteps.then_the_Group_Entry_page_and_its_contents_should_show_up();

        groupEntrySteps.when_I_click_Find_an_Existing_Value_button();

        groupEntrySteps.when_I_set_Search_Criteria_Group_Unit_Dropdown(SEARCH_CRITERIA_GROUP_UNIT_DROPDOWN);

        groupEntrySteps.when_I_set_Search_Criteria_Group_Unit(SEARCH_CRITERIA_GROUP_UNIT);

        groupEntrySteps.when_I_set_Search_Criteria_Group_ID_using_saved_Group_ID_1();

        groupEntrySteps.when_I_click_Search_Creteria_Search_Button();

        groupEntrySteps.then_the_Group_Control_page_for_Group_ID_1_should_show_up();

        groupEntrySteps.when_I_click_on_Return_to_Search_button();

        groupEntrySteps.when_I_set_Search_Criteria_Group_Unit(SEARCH_CRITERIA_GROUP_UNIT);

        groupEntrySteps.when_I_set_Search_Criteria_Group_ID_using_saved_Group_ID_2();

        groupEntrySteps.when_I_click_Search_Creteria_Search_Button();

        groupEntrySteps.then_the_Group_Control_page_for_Group_ID_2_should_show_up();


    }
}
