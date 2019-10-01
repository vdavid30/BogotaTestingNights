package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Board {
    private Logger LOGGER = Logger.getLogger(this.getClass());
    private String id;
    private String name;
    private ArrayList<String> listsId;
    private ArrayList<Card> cards;

    public Board(String id, String name){
        this.id = id;
        this.name= name;
        this.listsId = new ArrayList<>();
        this.cards = new ArrayList<>();
        LOGGER.info("Board created with name: "+ this.name);
        LOGGER.info("Board created with id: "+this.id);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public void addCard(String cardName, String cardId){
        this.cards.add(new Card(cardName, cardId));
        LOGGER.info("Card added with card name: "+cardName);
        LOGGER.info("Card added with card id: "+cardId);
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getListsId() {
        return listsId;
    }

    public void setListsId(ArrayList<String> listsId) {
        this.listsId = listsId;
    }

    public void addList(String listId){
        this.listsId.add(listId);
        LOGGER.info("List added with the Id : "+listId);
    }

    public String getLastListId(){
        return this.listsId.get(listsId.size()-1);
    }
}