package Model;

import java.util.ArrayList;

public class Board {
    private String id;
    private String name;
    private ArrayList<String> listsId;
    private ArrayList<Card> cards;

    public Board(String id, String name){
        this.id = id;
        this.name= name;
        this.listsId = new ArrayList<>();
        this.cards = new ArrayList<>();
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
    }


    public String getLastListId(){
        return this.listsId.get(listsId.size()-1);
    }
}