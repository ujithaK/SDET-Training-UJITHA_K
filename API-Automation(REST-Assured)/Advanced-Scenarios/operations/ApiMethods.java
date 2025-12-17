package operations;

import io.restassured.response.Response;
import java.io.File;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ApiMethods {

    // GET request
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

    // POST request (Map or POJO)
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

    // PUT request (Map or POJO)
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

    // DELETE request
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

    // Multipart file upload
    public static Response uploadFile(String endpoint, File file) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .multiPart("file", file)
                .when()
                .post(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }

    // GET request with cookies
    public static Response getWithCookies(String endpoint, Map<String, String> cookies) {
        return given()
                .spec(RestAssuredConfig.requestSpec)
                .cookies(cookies)
                .when()
                .get(endpoint)
                .then()
                .spec(RestAssuredConfig.responseSpec)
                .extract()
                .response();
    }
}

