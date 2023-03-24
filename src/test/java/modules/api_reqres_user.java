package modules;

import io.restassured.response.Response;

import static helpers.envVariable.*;
import static helpers.baseHelpers.*;
import static io.restassured.RestAssured.given;

public class api_reqres_user {

    private static Response pilot;
    private static String msReqres = setMs("MS_Reqres");

    public static Response reqresUser(String params1, String params2){
        pilot = given()
                .config(apiTimeout(20000))
                .contentType("application/json")
                .queryParam("page",params1)
                .queryParam("id",params2)
                .when()
                .get(msReqres+"/users");

        System.out.printf("Response body: ");
        pilot.getBody().prettyPrint();

        return pilot;
    }
}
