package utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Logger LOGGER = Logger.getLogger(this.getClass());
    private Properties properties;

    public PropertiesReader(){
        properties = new Properties();
        readProperties();
    }

    public void readProperties(){
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")){
            if (input == null) {
                LOGGER.info("The file config.properties doesn't exist");
            }
            properties.load(input);
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getKey(){
        return properties.getProperty("key");
    }

    public String getToken(){
        return properties.getProperty("token");
    }

    public String getGetPokemonUrl(){ return properties.getProperty("GET_POKEMON_URL"); }

    public String getCreateBoard (){
        return properties.getProperty("CREATE_BOARD");
    }

    public String getCreateList(){
        return properties.getProperty("CREATE_LIST");
    }

    public String getCreateCard(){ return properties.getProperty("CREATE_CARD"); }

    public String getCardsList(){return properties.getProperty("GET_CARDS_LIST");}
}
