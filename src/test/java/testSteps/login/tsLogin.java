package testSteps.login;

import com.google.gson.Gson;



import static mappings.mapper.*;
import static modules.api_login.*;
import static helpers.baseHelpers.*;

public class tsLogin {

    private static int responseCode;

    public static String loginStep(String data, String condition){

        String objBody = new Gson().toJson(yamlData(data));

        System.out.println("Request body: "+jsonPretty(String.valueOf(objBody)));

        responseCode = apiLogin(objBody).statusCode();

        switch (condition){
            case "Login successfully":
                if (responseCode != 200){
                    throw new RuntimeException("Not as expected, expected 200 but found "+ responseCode);
                }
                else {
                    System.out.println("Login successfully: " + responseCode);
                }
                break;
            case "Login failed":
                if (responseCode == 200){
                    throw new RuntimeException("Not as expected, found 200 but expected "+ responseCode);
                }
                else {
                    System.out.println("Login failed: " + responseCode);
                }
                break;
            default:
                throw new RuntimeException("Unrecognized condition!");
        }

        return null;

    }
}
