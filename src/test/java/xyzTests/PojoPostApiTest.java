package xyzTests;

import baseSuiteTest.BaseSuiteTest;
import builders.PojoBody;
import configs.EndPointsPath;
import configs.Headers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.JavaUtilFunctions;
import verifications.ResponseVerifications;

public class PojoPostApiTest extends BaseSuiteTest {

    @Test
    public void serializationTest(){

        Headers headers = new Headers();
        int idNum = 88 + JavaUtilFunctions.randomNum(100);
        String randomTitle = "testing-author" + JavaUtilFunctions.randonNumStr();
        String randomAuthor = "testing-title1"+ JavaUtilFunctions.randonNumStr();
        PojoBody pojoBody = new PojoBody(idNum, randomAuthor, randomTitle);

        Response response =
                RestAssured.given().headers(headers.defaultHeaders()).body(pojoBody)
                        .when().post(EndPointsPath.endPointPath.POST_AUTHOR);

        ResponseVerifications.statusCodeValidation(response, 201);
//        ResponseVerifications.timeLessThan1000(response);
        ResponseVerifications.keyExistsInJSONObjectValidation(response, "id");
        ResponseVerifications.keyValidationFromJsonObject(response, "title");
        ResponseVerifications.keyValidationFromJsonObject(response, "author");
    }


}
