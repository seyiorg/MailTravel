package support;

import io.restassured.http.ContentType;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static support.ConfigManager.getConfigDataFileData;

public class EmployeeApiSupport {

    public void createEmployeeRecord(String endpointExt) throws IOException {
        TestContext.endpoint = getConfigDataFileData("endpoint") + endpointExt;

        given()
                .baseUri(TestContext.endpoint)
                .contentType(ContentType.JSON)
                .log().all().body(TestContext.jsonDataFile)
                .when().post().then().log().all()
                .statusCode(200);
    }

    public void getAllEmployeeRecords(String endpointExt) throws IOException {
        TestContext.endpoint = getConfigDataFileData("endpoint") + endpointExt;
        given()
                .log()
                .all()
                .when().get(TestContext.endpoint)
                .then().assertThat().statusCode(200)
                .log().all();
    }

}
