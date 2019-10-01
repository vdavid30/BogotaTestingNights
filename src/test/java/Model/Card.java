package model;

import org.apache.log4j.Logger;

public class Card {
    private Logger LOGGER = Logger.getLogger(this.getClass());
    private String name;
    private String id;

    public Card(String name, String id){
        this.name = name;
        this.id = id;
        LOGGER.info("Card created with name: "+ this.name);
        LOGGER.info("Card created with id: "+this.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
