package xyzTests;

import baseSuiteTest.BaseSuiteTest;
import builders.Builders;
import com.relevantcodes.extentreports.LogStatus;
import configs.EndPointsPath;
import configs.Headers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.JavaUtilFunctions;
import verifications.ResponseVerifications;

public class PostApiTest extends BaseSuiteTest {

    protected Headers headers = new Headers();
    protected Builders builders = new Builders();
    protected Response response;

    @Test
    public void postAuthorTest() {

        extentTest.log(LogStatus.INFO, "My test is starting...");

        response = RestAssured.given().headers(headers.headersWithToken())
                .body(builders.bodyBuilder("1252221" + JavaUtilFunctions.randonNumStr(),
                        "title-test2221"+ JavaUtilFunctions.randomString(),
                        "me-author2221" + JavaUtilFunctions.randomString()))
                .when().post(EndPointsPath.endPointPath.POST_AUTHOR);

        ResponseVerifications.statusCodeValidation(response, 201);
        ResponseVerifications.keyValidationFromJsonObject(response, "id");
        ResponseVerifications.keyValidationFromJsonObject(response, "title");
        ResponseVerifications.keyValidationFromJsonObject(response, "author");
        ResponseVerifications.timeLessThan1000(response);

        extentTest.log(LogStatus.INFO, "My test is ended...");

    }
}
