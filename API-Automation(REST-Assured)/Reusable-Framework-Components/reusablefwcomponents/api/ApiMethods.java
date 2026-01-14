package reusablefwcomponents.api;

import io.restassured.response.Response;
import reusablefwcomponents.RestAssuredConfig;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    public static Response get(String endpoint) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .when()
                .get(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }
    public static Response post(String endpoint, Object body) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }

    public static Response put(String endpoint, Object body) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }

    public static Response delete(String endpoint) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }
}
