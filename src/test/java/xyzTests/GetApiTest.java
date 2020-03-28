package xyzTests;

import baseSuiteTest.BaseSuiteTest;
import builders.PojoCredentials;
import configs.EndPointsPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.JavaUtilFunctions;
import verifications.ResponseVerifications;

public class GetApiTest extends BaseSuiteTest{

    @Test
    public void GETTest() {

        Response response = RestAssured.given().when().get(EndPointsPath.endPointPath.GET_AUTHOR);

        ResponseVerifications.statusCodeValidation(response, 200);
        ResponseVerifications.timeLessThan1000(response);
        ResponseVerifications.keyValidationFromJSONArraysFirstObject(response, "title", "json-server");
        ResponseVerifications.keyValidationFromAnywhereInJSONArray(response, "id", "965");
//        ResponseVerifications.keyExistsInJSONObjectValidation(response, "title");     //Current API is a JSONArray
//        ResponseVerifications.keyValidationFromJsonObject(response, "title");     //Current API is a JSONArray
        ResponseVerifications.keyValuesValidationFromJsonArray(response, "id");
    }

}
