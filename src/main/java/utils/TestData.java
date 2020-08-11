package utils;

import net.thucydides.core.util.SystemEnvironmentVariables;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;


public class TestData {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestData.class);
    private static boolean useCustomParameters = Boolean.parseBoolean(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("useCustomParameters"));
    JSONObject jsonObject;

    public TestData (String scenario) {
        jsonObject = getJsonObj(scenario);
    }

    private JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getString (String key) {
        return (String) getJsonObject().get(key);
    }

    public int getInt (String key) {
        try {
            return (int) ((long) getJsonObject().get(key));
        } catch (Exception e) {
            LOGGER.error(e.toString());
            try {
                return Integer.parseInt((String) getJsonObject().get(key));
            } catch (Exception e2) {
                LOGGER.error(e2.toString());
            }
        }
        return -1;
    }

    private static JSONObject getJsonObj(String scenario) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/testData/" + scenario + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
