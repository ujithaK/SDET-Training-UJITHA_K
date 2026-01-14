package reusablefwcomponents;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredConfig {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    static {
        RestAssured.baseURI = BASE_URI;

        requestSpec = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
