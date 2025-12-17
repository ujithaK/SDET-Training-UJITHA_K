package operations;

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
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(JSON)
                .log(io.restassured.filter.log.LogDetail.ALL) // it'll log all requests
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(JSON)
                .log(io.restassured.filter.log.LogDetail.ALL) // log all responses
                .build();
    }
}

