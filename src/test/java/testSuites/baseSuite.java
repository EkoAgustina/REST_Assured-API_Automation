package testSuites;

import com.google.common.collect.ImmutableMap;
import org.testng.SuiteRunState;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static helpers.envVariable.*;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class baseSuite {
    private static String parseMs(){
      String objEnv = Arrays.toString(allureEnv());
      String setMs = String.valueOf(objEnv.split(",")[0].replace("[",""));

      return setMs.replace("_"," ");
    }
    private static String parseUrl(){
        String objUrl = Arrays.toString(allureEnv());
        String setUrl = String.valueOf(objUrl.split(",")[1].replace("]",""));

        return setUrl.replace(" ","");
    }


    @AfterSuite(alwaysRun = true)
    void afterSuite() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put(parseMs(), parseUrl())
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }
}
