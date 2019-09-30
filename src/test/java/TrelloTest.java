import cucumber.api.CucumberOptions;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import steps.TrelloSteps;

@Epic("Trello API Basic Testing")
@Feature("Trello integration with Pokemon API")
@CucumberOptions(features = "src/test/resources/features", glue = "steps", plugin = {"pretty"})
public class TrelloTest extends BaseTest {
    private static final ThreadLocal<TrelloSteps> trelloSteps = ThreadLocal.withInitial(TrelloSteps::new);

    @Story("Get the Pokemon information from API")
    @Issue("Get the Pokemon information from API")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "The user wants to consult his Pokemon information on the Pokemon API")
    public void getPokemonInformationFromAPI(){
        trelloSteps.get()
                .theUserWantsToConsultInformationOnThePokemonAPI("eevee")
                .theUserRequestThePokemonInformationToThePokemonAPI()
                .thePokemonAPIWillReturnTheCorrectInformationAboutThePokemon()
                .verifyAll();
    }

    @Story("Get the Pokemon information from API with invalid conditions")
    @Issue("Get the Pokemon information from API with invalid conditions")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "The user wants to consult his Pokemon information on the Pokemon API with invalid criteria")
    public void getPokemonInvalidInformationFromAPI(){
        trelloSteps.get()
                .theUserWantsToConsultInformationOnThePokemonAPI("eevee")
                .theUserRequestThePokemonInformationToThePokemonAPI()
                .thePokemonAPIWillReturnTheInCorrectInformationAboutThePokemon()
                .verifyAll();
    }


    @Story("Create my personal Board with a list of my favorite Pokemon")
    @Issue("Create my personal Board with a list of my favorite Pokemon")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "The user wants to create his personal Pokemon team on Trello")
    public void canCreateMyPersonalBoardOfPokemon() {
        trelloSteps.get()
                .theUserWantsToCreateHisPersonalPokemonTeamOnTrello()
                .theUserCreatesABoardOnTrello("Pokemon Information")
                .theUserCreatesAListNamedOnTheCreatedBoard("Pokemon Fight Team")
                .theUserAddAPokemonCalledToTheList("eevee")
                .theUserCanSeeOnHisListHisFavoritePokemon("eevee")
                .verifyAll();
    }
}
