package testSteps.reqres;

import io.restassured.response.ValidatableResponse;

import static mappings.mapper.*;
import static modules.api_reqres_user.*;
import static helpers.baseHelpers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class tsReqres {

    private static int responseCode;
    private static ValidatableResponse validatableResponse;

    public static String reqresStep(){

        responseCode = reqresUser("2","7").statusCode();

        if(responseCode != 200){
            throw new RuntimeException("Not as expected, expected 200 but found "+ responseCode);
        }
        else {
            System.out.println("Get user reqres successfully: "+responseCode);
        }



        return null;
    }
}
