package Utils;

import java.net.MalformedURLException;
import java.net.URL;

public class RequestUtil {


    private PropertiesReader propertiesReader;

    public RequestUtil(){
        this.propertiesReader = new PropertiesReader();
    }


    public  URL getPokemonURL(String pokemon) {
        return createURL(propertiesReader.getGetPokemonUrl()+pokemon);
    }

    public  URL getBoardsList() {
        return createURL(propertiesReader.getGetBoardsList());
    }

    public  URL createBoard() {
        return createURL(propertiesReader.getCreateBoard());
    }

    public  URL createList(){
        return createURL(propertiesReader.getCreateList());
    }

    public  URL createCard(){
        return createURL(propertiesReader.getCreateCard());
    }

    public  URL getCardsOfABoard(String boardId)  {
        return createURL(propertiesReader.getCardsList()+boardId+"/cards/");
    }

    public URL createURL(String link){
        URL url = null;
        try{
            url =  new URL(link);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }finally {
            return  url;
        }

    }

}
