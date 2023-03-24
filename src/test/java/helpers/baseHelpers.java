package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class baseHelpers {

    public static RestAssuredConfig apiTimeout(int timeout){
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout",timeout)
                        .setParam("http.connection.timeout",timeout)
                );
        return config;
    }
    public static String jsonPretty(String object){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(object);
        String prettyJson = gson.toJson(jsonElement);

        return prettyJson;
    }
}
