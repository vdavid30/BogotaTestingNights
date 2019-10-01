package controllers;

import enums.Types;
import model.Board;
import utils.PropertiesReader;
import io.restassured.response.Response;
import java.util.HashMap;

public class TrelloController {

    private HashMap<String, String> parameters;
    private PropertiesReader propertiesReader;
    private Board board;

    public TrelloController(){
        this.parameters = new HashMap<>();
        this.propertiesReader = new PropertiesReader();
    }

    private void getAuthParameters() {
        this.parameters.clear();
        this.parameters.put("key", propertiesReader.getKey());
        this.parameters.put("token", propertiesReader.getToken());
    }

    public HashMap<String,String> getParameters(Types type, String name){
        getAuthParameters();
        switch(type){
            case BOARD:
                this.parameters.put("name", name);
                break;
            case LIST:
                this.parameters.put("name", name);
                this.parameters.put("idBoard", board.getId());
                break;
            case CARD:
                this.parameters.put("idList", board.getLastListId());
                this.parameters.put("name", name);
                break;
            case POKEMON:
                this.parameters.put("fields", name);
                break;
        }
        return parameters;
    }

    public void createBoard(Response response){
        this.board =  new Board(response.getBody().path("id").toString(), response.getBody().path("name").toString());
    }

    public void associateListToABoard(Response response){
        this.board.addList(response.getBody().path("id").toString());
    }


    public void associateCardToAList(Response response){
        this.board.addCard(response.getBody().path("name").toString(), response.getBody().path("id").toString());
    }

    public String getBoardId(){
        return  this.board.getId();
    }








}
