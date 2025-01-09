package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static endpoints.Endpoints.USERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTest extends BaseTest {
    String validEmailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @Test
    public void shouldHaveValidEmail() {
        given()
                .log().all()
                .when()
                .get(USERS)
                .then()
                .log().all()
                .statusCode(200)
                .body("email", matchesPattern(validEmailRegex));
    }

    @Test
    public void shouldCityNotBeNull() {
        given().log().all()
                .when()
                .get(USERS)
                .then()
                .log().all()
                .statusCode(200)
                .body("address.city", notNullValue());
    }
}
