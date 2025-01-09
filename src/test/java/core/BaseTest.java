package core;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest implements Constants{

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = APP_BASE_URL;
    }
}
