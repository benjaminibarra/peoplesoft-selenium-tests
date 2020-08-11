package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessTestData {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessTestData.class);
    private static final String JSON_FILES_PARENT_DIR = "src/main/java/testData";

    public static void main (String args[]) {
        try {
            String input = args[0];
//        String input = "\"[[{\"addAnAlternateUser\": [{\"USER_TO_ADD\": \"75765\"}, {\"EMAIL\": \"bibarra@icrc.org\"}]}], [{\"addAndRemoveAuthorizedUser\": [{\"USER_TO_ADD\": \"Ruben Pablo II CUBA\"}, {\"NUMBER_OF_USERS_TO_ADD\": \"2\"}]}], [{\"checkSendB\n" +
//                "ackDenyAndApproveClaim\": [{\"CURRENCY\": \"PHP\"}, {\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"MISSION_LOCATION\": \"Philippines\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Medical CheckUp & Vaccinations\"}, {\"AMOUNT\": \"1000\"}, {\"DESCRIPTION\": \"Test1\"}, {\"CLAIM_TYPE\": \"Sundry\"}, {\"COS\n" +
//                "T_CENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINESS_UNIT\": \"FD\"}, {\"COMMENT\": \"Sample Comment\"}]}], [{\"createAccommodationClaimReport\": [{\"CURRENCY\": \"PHP\"}, {\"NUMBER_OF_NIGHTS\": \"1\"}, {\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"MISSION_LOCATION\"\n" +
//                ": \"Philippines\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Hotel/Accom,Laundry/Breakfast\"}, {\"AMOUNT\": \"1000\"}, {\"DESCRIPTION\": \"Test1\"}, {\"CLAIM_TYPE\": \"FD BoM/EoM Missions\"}, {\"COST_CENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINESS_UNIT\": \"FD\"}]}], [{\"creat\n" +
//                "eAllowanceClaimReport\": [{\"DEDUCTION\": \"2\"}, {\"NUMBER_OF_NIGHTS\": \"1\"}, {\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"MISSION_LOCATION\": \"Switzerland\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Travelling allowance\"}, {\"DESCRIPTION\": \"Test1\"}, {\"CLAIM_TYPE\": \"MEDICALS\"}, {\"COST_C\n" +
//                "ENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINESS_UNIT\": \"FD\"}]}], [{\"createEntertainmentClaimReport\": [{\"CURRENCY\": \"PHP\"}, {\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"MISSION_LOCATION\": \"Philippines\"}, {\"ATTENDEE_COMPANY\": \"ABC\"}, {\"ATTENDEE_LAS\n" +
//                "T_NAME\": \"Smith\"}, {\"ATTENDEE_FIRST_NAME\": \"John\"}, {\"COST_CENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINESS_UNIT\": \"FD\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Entertain./Invit.Res\"}, {\"AMOUNT\": \"1000\"}, {\"DESCRIPTION\": \"Test1\"}, {\"CLAIM_TYPE\": \"HQ/FD MIS\n" +
//                "SIONS\"}, {\"ATTENDEE_TITLE\": \"Dr.\"}]}], [{\"createStandardClaimReport\": [{\"CURRENCY\": \"PHP\"}, {\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"MISSION_LOCATION\": \"Philippines\"}, {\"AMOUNT_2\": \"100\"}, {\"COST_CENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINE\n" +
//                "SS_UNIT\": \"FD\"}, {\"DESCRIPTION_2\": \"Test2\"}, {\"EXPENSE_TYPE_TO_SELECT_2\": \"Newspaper/Membership/Subs/Docs\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Medical CheckUp & Vaccinations\"}, {\"AMOUNT\": \"1000\"}, {\"DESCRIPTION\": \"Test1\"}, {\"CLAIM_TYPE\": \"Sundry\"}, {\"CURRENCY_2\": \"USD\"}]\n" +
//                "}], [{\"createTransportationClaimReport\": [{\"USER_NOTES_MESSAGE\": \"Sample Message\"}, {\"ORIGIN\": \"Geneva, Switzerland\"}, {\"MISSION_LOCATION\": \"Switzerland\"}, {\"EXPENSE_TYPE_TO_SELECT\": \"Car Allow-Work Related Travel\"}, {\"DESCRIPTION\": \"Test1\"}, {\"DESTINATION\": \"Zuric\n" +
//                "h, Switzerland\"}, {\"CLAIM_TYPE\": \"FD BoM/EoM Missions\"}, {\"COST_CENTER\": \"MSC\"}, {\"EMPLOYEE_NAME\": \"Angelo Germy Gutay\"}, {\"BUSINESS_UNIT\": \"FD\"}]}]]\"";

            String jsonStr = input.replaceAll("\\\\", "").substring(1, input.length() - 1).replaceAll("\n", "");
            JsonParser jsonParser = new JsonParser();
            JsonElement element = jsonParser.parse(jsonStr);

            for (JsonElement jsonElement : element.getAsJsonArray()) {
                writeToJsonFile(JSON_FILES_PARENT_DIR, jsonElement);
            }
        } catch (Exception e) {
            LOGGER.error("An error occured while modifying test data!");
            LOGGER.error(e.toString());
        }
    }

    public static String mergeJsonArrayObjects (JsonArray jsonArray) {
        List<String> jsonStrList = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            jsonStrList.add(jsonElement.toString().substring(1, jsonElement.toString().length() - 1));
        }
        String jsonStrListStr = jsonStrList.toString();
        return "{" + jsonStrListStr.substring(1, jsonStrListStr.length() - 1) + "}";
    }

    public static void writeToJsonFile (String parentDir, JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonArray().get(0).getAsJsonObject();
        File jsonFile = new File(parentDir + "/" + jsonObject.keySet().toArray()[0] + ".json");
        FileWriter file = null;
        String jsonStrToWrite = mergeJsonArrayObjects(jsonObject.get(jsonObject.keySet().toArray()[0].toString()).getAsJsonArray());
        LOGGER.info(jsonStrToWrite);
        try {
            file = new FileWriter(jsonFile.getAbsoluteFile());
            file.write(jsonStrToWrite);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static JsonArray getJsonArray (String[] jsonArrStr) {
        JsonArray jsonArray = new JsonArray();
        for (String x : jsonArrStr){
            JsonParser jsonParser = new JsonParser();
            JsonElement element = jsonParser.parse(x);
            jsonArray.add(element.getAsJsonArray().get(0));
        }
        return jsonArray;
    }

    public static String[] processInputJsonString (String jsonStr) {
        jsonStr = jsonStr.replaceAll("\\\\", "");
        String[] scenarioJsonStrs = jsonStr.substring(1, jsonStr.length()-1).split("\",\"");
        return scenarioJsonStrs;
    }
}
