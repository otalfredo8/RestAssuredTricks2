package baseSuiteTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.EnvironmentFileSelector;
import utilities.ListenerWithReport;

//For the report
@Listeners(ListenerWithReport.class)
public class BaseSuiteTest extends ListenerWithReport {

    @BeforeClass
    public void baseURLSetting(){
        // We can pre-set multiple RestAssured public static variables: baseURI, rootPath,
        // requestSpecification, defaultParser, responseSpecification, sessionId,... etc.
        RestAssured.baseURI = EnvironmentFileSelector.envFileSelected().get("ServerUrl");
    }
}
