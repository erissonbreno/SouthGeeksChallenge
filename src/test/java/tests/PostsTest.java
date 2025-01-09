package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static endpoints.Endpoints.POSTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsTest extends BaseTest {

    private static Stream<String> bodyAttributes() {
        return Stream.of("title", "body");
    }

    @ParameterizedTest
    @MethodSource("bodyAttributes")
    public void shouldTitleNotBeEmpty(String attribute) {
        given().log().all()
                .when()
                .get(POSTS)
                .then()
                .log().all()
                .statusCode(200)
                .body(attribute, is(not(emptyString())));
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
