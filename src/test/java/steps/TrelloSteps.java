package steps;

import Controllers.RequestController;
import Controllers.TrelloController;
import Utils.RequestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class TrelloSteps extends BaseSteps{
    private RequestController requestController;
    private TrelloController trelloController;
    private RequestUtil requestUtil;
    private String pokemonName;
    private Response response;
    public TrelloSteps() {
        super();
        requestController = new RequestController();
        requestUtil = new RequestUtil();
    }

    @Step("The user wants to consult {string} information on the Pokemon API")
    @Given("The user wants to consult {string} information on the Pokemon API")
    public TrelloSteps theUserWantsToConsultInformationOnThePokemonAPI(String pokemonName) {
        this.pokemonName = pokemonName;
        return this;
    }

    @Step("The user request the pokemon information to the Pokemon API")
    @When("The user request the pokemon information to the Pokemon API")
    public TrelloSteps theUserRequestThePokemonInformationToThePokemonAPI(){
        response = requestController.getRequest(requestUtil.getPokemonURL(this.pokemonName));
        return this;

    }

    @Step("The Pokemon API will return the correct information about the Pokemon")
    @Then("The Pokemon API will return the correct information about the Pokemon")
    public TrelloSteps thePokemonAPIWillReturnTheCorrectInformationAboutThePokemon() {
        softly.assertThat(response.getBody().path("name").toString())
                .isEqualTo(pokemonName);
        LOGGER.info("The actual name is: "+response.getBody().path("name").toString());
        return this;
    }


    @Step("The Pokemon API will return the correct information about the Pokemon")
    @Then("The Pokemon API will return the correct information about the Pokemon")
    public TrelloSteps thePokemonAPIWillReturnTheInCorrectInformationAboutThePokemon() {
        softly.assertThat(response.getBody().path("name").toString())
                .isEqualTo(pokemonName+"no");
        LOGGER.info("The actual name is: "+response.getBody().path("name").toString());
        return this;
    }

    @Step("The user wants to create his personal Pokemon team on Trello")
    @Given("The user wants to create his personal Pokemon team on Trello")
    public TrelloSteps theUserWantsToCreateHisPersonalPokemonTeamOnTrello() {
        trelloController = new TrelloController();
        return this;
    }

    @Step("The user creates a board called {string} on Trello")
    @When("The user creates a board called {string} on Trello")
    public TrelloSteps theUserCreatesABoardOnTrello(String boardName)  {
        response = requestController.postRequest(requestUtil.createBoard(), trelloController.getParameters("Create a board", boardName));
        softly.assertThat(response.getBody().path("name").toString())
                .isEqualTo(boardName);
        trelloController.createBoard(response);
        return this;
    }
    @Step("The user creates a list named {string} on the created board")
    @And("The user creates a list named {string} on the created board")
    public TrelloSteps theUserCreatesAListNamedOnTheCreatedBoard(String listName)  {
        response = requestController.postRequest(requestUtil.createList(), trelloController.getParameters("Add list to a board", listName));
        softly.assertThat(response.getBody().path("name").toString())
                .isEqualTo(listName);
        trelloController.associateListToABoard(response);
        return this;
    }

    @Step("The user add a Pokemon called {string} to the list")
    @And("The user add a Pokemon called {string} to the list")
    public TrelloSteps theUserAddAPokemonCalledToTheList(String pokemonName)  {
        response = requestController.postRequest(requestUtil.createCard(), trelloController.getParameters("Add a card to a list", pokemonName));
        softly.assertThat(response.getBody().path("name").toString())
                .isEqualTo(pokemonName);
        trelloController.associateCardToAList(response);
        return this;
    }

    @Step("The user can see on his list his favorite Pokemon {string}")
    @Then("The user can see on his list his favorite Pokemon {string}")
    public TrelloSteps theUserCanSeeOnHisListHisFavoritePokemon(String pokemonName)  {
        response = requestController.getRequest(requestUtil.getCardsOfABoard(trelloController.getBoardId()),trelloController.getParameters("Consult Pokemons", "name"));
        softly.assertThat(response.getBody().asString())
                .contains(pokemonName);
        return this;
    }
}
