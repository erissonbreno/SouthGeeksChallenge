package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static endpoints.Endpoints.USERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTest extends BaseTest {
    String validEmailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void shouldHaveValidEmail(int userId) {
        given()
                .log().all()
                .when()
                .get(USERS + userId)
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
