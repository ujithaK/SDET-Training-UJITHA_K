package reusablefwcomponents;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.http.ContentType.JSON;

public class RestAssuredConfig {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    static {
        // Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(JSON)
                .build();

        // Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(JSON)
                .build();
    }
}
