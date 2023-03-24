package testSteps.register;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static mappings.mapper.*;
import static modules.api_Register.*;
import static helpers.baseHelpers.*;

public class tsRegister {

    private static int responseCode;

    public static String registerStep(String data,String nama_lengkap, String alamat_lengkap, String username){
        String obj = new Gson().toJson(yamlData(data));

        HashMap mapBody = new HashMap() {
        };
        mapBody.put("nama_lengkap", JsonPath.read(obj,"$.nama_lengkap")+" "+nama_lengkap);
        mapBody.put("alamat_lengkap",JsonPath.read(obj,"$.alamat_lengkap")+" "+alamat_lengkap);
        mapBody.put("username",JsonPath.read(obj,"$.username")+username);
        mapBody.put("password", JsonPath.read(obj,"$.password"));

        String objBody = new Gson().toJson(mapBody);

        System.out.println("Request body: "+jsonPretty(objBody));
        responseCode = apiRegister(objBody).statusCode();

        if(responseCode != 200){
            throw new RuntimeException("Not as expected, expected 200 but found "+ responseCode);
        }
        else{
            System.out.println("Register successfully: "+responseCode);
        }

        return null;
    }
}
