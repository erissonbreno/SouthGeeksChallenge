package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static endpoints.Endpoints.POSTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void shouldTitleNotBeEmpty(int postId) {
        given().log().all()
                .when()
                .get(POSTS + postId)
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
