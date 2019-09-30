package steps;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class BaseSteps {

    SoftAssertions softly;
    Logger LOGGER = Logger.getLogger(this.getClass());

    public BaseSteps() {
        softly = new SoftAssertions();
    }

    public void verifyAll() {
        softly.assertAll();
    }
}
