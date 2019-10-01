package controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.net.URL;
import java.util.HashMap;

public class RequestController {
    private RequestSpecification requestSpecification;

    public RequestController(){ }

    public Response getRequest(URL webURL, HashMap<String,String> parameters){
        requestSpecification = RestAssured.given().queryParams(parameters).and().contentType("application/json");
        return requestSpecification.when().get(webURL);
    }


    public Response getRequest(URL webURL){
        requestSpecification = RestAssured.given().contentType("application/json");
        return requestSpecification.when().get(webURL);
    }

    public Response postRequest(URL webURL, HashMap<String, String> parameters){
        requestSpecification = RestAssured.given().queryParams(parameters).and().contentType("application/json");
        return requestSpecification.when().post(webURL);
    }

}
