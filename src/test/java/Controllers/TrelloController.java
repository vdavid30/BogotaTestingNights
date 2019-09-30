package Controllers;

import Model.Board;
import Utils.PropertiesReader;
import io.restassured.response.Response;
import java.util.HashMap;

public class TrelloController {

    private RequestController requestController;
    private HashMap<String, String> parameters;
    private PropertiesReader propertiesReader;
    private Board board;

    public TrelloController(){
        this.parameters = new HashMap<>();
        this.requestController = new RequestController();
        this.propertiesReader = new PropertiesReader();
    }

    public HashMap<String,String> getAuthParameters() {
        this.parameters.clear();
        this.parameters.put("key", propertiesReader.getKey());
        this.parameters.put("token", propertiesReader.getToken());
        return parameters;
    }

    public HashMap<String,String> getParameters(String typeOfRequest, String name){
        getAuthParameters();
        switch(typeOfRequest){
            case "Create a board":
                this.parameters.put("name", name);
                break;
            case "Add list to a board":
                this.parameters.put("name", name);
                this.parameters.put("idBoard", board.getId());
                break;
            case "Add a card to a list":
                this.parameters.put("idList", board.getLastListId());
                this.parameters.put("name", name);
                break;
            case "Consult Pokemons":
                this.parameters.put("fields", name);
                break;
        }
        return parameters;
    }

    public void createBoard(Response response){
        this.board = requestController.generateBoard(response);
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
