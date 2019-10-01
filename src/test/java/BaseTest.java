import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.*;

public abstract class BaseTest{
    @BeforeSuite
    public void startSuite() {
        BasicConfigurator.configure();
        RestAssured.replaceFiltersWith(new AllureRestAssured());
    }

    @BeforeMethod
    public void initializeData() { }

    @AfterMethod
    public void closeDataStream() { }

    @AfterSuite
    public void stopSuite() { }

}