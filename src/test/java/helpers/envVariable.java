package helpers;


import io.github.cdimascio.dotenv.Dotenv;

import java.io.UnsupportedEncodingException;

public class envVariable {

    private static String declare;
    private static String loadEnv(String baseEnv){
        Dotenv dotenv = Dotenv.load();
        return dotenv.get(baseEnv);
//        return setEnv;
    }
    public static String setMs(String url){
        declare = url;
        if ( url.isEmpty() == true || url == null){
            throw new RuntimeException("Url is required");
        }
        else{
            if (declare == "MS_Auth"){
                return loadEnv("MS_Auth");
            } else if (declare == "MS_Reqres") {
                return loadEnv("MS_Reqres");
            } else {
                throw new RuntimeException("Services not found");
            }
        }
    }
    public static String[] allureEnv() {
        return new String[]{declare,setMs(declare)};
    }




}
