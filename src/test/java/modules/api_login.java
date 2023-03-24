package modules;

import io.restassured.response.Response;


import static helpers.envVariable.*;
import static helpers.baseHelpers.*;

import static io.restassured.RestAssured.given;

public class api_login {

   private static Response pilot;

   private static String msAuth = setMs("MS_Auth");

    public static Response apiLogin(String object){
        pilot = given()
                .config(apiTimeout(20000))
                .contentType("application/json")
                .body(object)
                .when()
                .post(msAuth +"/login");

        System.out.printf("Response body: ");
        pilot.getBody().prettyPrint();
        return pilot;
    }

}
