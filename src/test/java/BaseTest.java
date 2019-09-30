import Utils.RequestUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public abstract class BaseTest{
    Logger logger = Logger.getLogger(this.getClass());
    private RequestUtil requestUtil;

    @BeforeSuite
    public void startSuite() {
        BasicConfigurator.configure();
        RestAssured.replaceFiltersWith(new AllureRestAssured());
        requestUtil = new RequestUtil();
    }

    @BeforeMethod
    public void initializeData() {

    }

    @AfterMethod
    public void closeDataStream() {

    }

    @AfterSuite
    public void stopSuite() {

    }


}