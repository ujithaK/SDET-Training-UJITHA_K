import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationTest {

    // Reusable token (OAuth-style)
    private static String accessToken;

    @BeforeClass
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    // 1️ Basic Authentication
    @Test
    public void basicAuthTest() {
     //Implementing Basic Auth using .auth().basic()
        given()
                .auth()
                .basic("user", "passwd")
                .when()
                .get("https://httpbin.org/basic-auth/user/passwd")
                .then()
                .statusCode(200);
    }

    // 2️ Bearer Token Authentication
    @Test
    public void bearerTokenTest() {

        String token = "dummyBearerToken123";
       //Using Bearer token in headers.
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://httpbin.org/bearer")
                .then()
                .statusCode(200);
    }

    // 3️ Generating OAuth-style Token
    @Test
    public void generateToken() {

        if (accessToken == null) {

            String response =
                    given()
                            .header("Content-Type", "application/json")
                            .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
                            .when()
                            .post("https://reqres.in/api/login")
                            .then()
                            .statusCode(200)
                            .extract()
                            .asString();

            accessToken = JsonPath.from(response).getString("token");  //Storing token
            System.out.println("Generated Token: " + accessToken);
        }
    }

    // 4️ Using Generated Token
    @Test(dependsOnMethods = "generateToken")
    public void useTokenTest() {

        given()
                .header("Authorization", "Bearer " + accessToken)  //reusing the token
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }
}
