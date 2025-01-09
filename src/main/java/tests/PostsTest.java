package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static endpoints.Endpoints.POSTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsTest extends BaseTest {

    @Test
    public void shouldTitleNotBeEmpty() {
        given().log().all()
                .when()
                .get(POSTS)
                .then()
                .log().all()
                .statusCode(200)
                .body("title", is(not(emptyString())));
    }

    @Test
    public void shouldUserIdBeAPositiveNumber() {
        given()
                .log().all()
                .when()
                .get(POSTS)
                .then()
                .log().all()
                .statusCode(200)
                .body("userId", is(greaterThan(0)));
    }
}
