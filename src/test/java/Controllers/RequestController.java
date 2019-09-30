package Controllers;

import Model.Board;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.net.URL;
import java.util.HashMap;

public class RequestController {
    private RequestSpecification requestSpecification;
    private Response response;

    public RequestController(){ }

    public Response getRequest(URL webURL, HashMap<String,String> parameters){
        requestSpecification = RestAssured.given().queryParams(parameters).and().contentType("application/json");
        response = requestSpecification.when().get(webURL);
        return response;
    }


    public Response getRequest(URL webURL){
        requestSpecification = RestAssured.given().contentType("application/json");
        response = requestSpecification.when().get(webURL);
        return response;
    }

    public Response postRequest(URL webURL, HashMap<String, String> parameters){
        requestSpecification = RestAssured.given().queryParams(parameters).and().contentType("application/json");
        response = requestSpecification.when().post(webURL);
        return response;
    }

    public Board generateBoard(Response response){
        return new Board(response.getBody().path("id").toString(), response.getBody().path("name").toString());
    }




}
