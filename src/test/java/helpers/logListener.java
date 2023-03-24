package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static helpers.baseHelpers.*;
import static helpers.baseHelpers.jsonPretty;

public class logListener implements ITestListener {
   private ByteArrayOutputStream request = new ByteArrayOutputStream();
   private ByteArrayOutputStream response = new ByteArrayOutputStream();
   private PrintStream requestVar = new PrintStream(request,true);
   private PrintStream responseVar = new PrintStream(response,true);




   public void onStart (final ITestContext iTestContext){
       RestAssured.filters(new RequestLoggingFilter(LogDetail.URI,requestVar));
       RestAssured.filters(new RequestLoggingFilter(LogDetail.METHOD,requestVar));
       RestAssured.filters(new RequestLoggingFilter(LogDetail.BODY,requestVar));

       RestAssured.filters(new ResponseLoggingFilter(LogDetail.BODY,responseVar));

   }
   public void onTestSuccess(final ITestResult iTestResult){
       logRequest(request);
       logResponse(response);
   }
    @Attachment(value = "Request")
    public byte[] logRequest(final ByteArrayOutputStream stream){
       return  attach(stream);
   }
    @Attachment(value = "response")
    public byte[] logResponse(final ByteArrayOutputStream stream){
       return  attach(stream);
    }

    public byte[] attach(final ByteArrayOutputStream log){
       final byte[] array = log.toByteArray();
       log.reset();
       return array;
    }


}
