package Validation;

import crudOperations.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AuthCRUDTest extends BaseTest {

    private static final String username = "ujitha";
    private static final String updated_username = "manasa";

    // ✅ Authentication details
    private static final String BASIC_USERNAME = "admin";
    private static final String BASIC_PASSWORD = "admin123";
    private static String bearerToken;

    // 0️⃣ Fetch Bearer Token (simulated OAuth / auth endpoint)
    @BeforeClass
    public void getBearerToken() {
        // Example POST request to auth endpoint to get token
        bearerToken =
                given()
                        .contentType(ContentType.JSON)
                        .body("{ \"username\": \"" + BASIC_USERNAME + "\", \"password\": \"" + BASIC_PASSWORD + "\" }")
                        .when()
                        .post("/auth")  // Replace with actual token endpoint if exists
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("token");  // Extract token from response
    }

    // 1️⃣ POST – Create new user with Basic Auth
    @Test(priority = 1)
    public void createUser() {

        String requestBody = """
                [
                  {
                    "id": 101,
                    "username": "ujitha",
                    "firstName": "uji",
                    "lastName": "ujitha",
                    "email": "uji@gmail.com",
                    "password": "ujitha",
                    "phone": "6376981792",
                    "userStatus": 0
                  }
                ]
                """;

        Response response =
                given()
                        .auth().basic(BASIC_USERNAME, BASIC_PASSWORD)   // Basic Auth
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/user/createWithList")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(3000L))
                        .extract().response();

        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, "ok");
    }

    // 2️⃣ GET – Fetch single user with Bearer Token
    @Test(priority = 2)
    public void getSingleUser() {

        Response response =
                given()
                        .header("Authorization", "Bearer " + bearerToken)  // Bearer Token
                        .log().all()
                        .when()
                        .get("/user/" + username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(3000L))
                        .body(matchesJsonSchemaInClasspath("schemas/userSchema.json"))
                        .extract().response();

        int id = response.jsonPath().getInt("id");
        String uname = response.jsonPath().getString("username");
        String email = response.jsonPath().getString("email");

        Assert.assertEquals(id, 101);
        Assert.assertEquals(uname, username);
        Assert.assertTrue(email.contains("@"));
    }

    // 3️⃣ PUT – Update user with Bearer Token
    @Test(priority = 3)
    public void updateUser() {

        String requestBody = """
                {
                  "id": 101,
                  "username": "manasa",
                  "firstName": "Ujitha",
                  "lastName": "K",
                  "email": "ujitha@gmail.com",
                  "password": "newpassword",
                  "phone": "9999999999",
                  "userStatus": 1
                }
                """;

        Response response =
                given()
                        .header("Authorization", "Bearer " + bearerToken)  // Bearer Token
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/user/" + username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(3000L))
                        .extract().response();

        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, "101");
    }

    // 4️⃣ DELETE – Remove user with Bearer Token
    @Test(priority = 4)
    public void deleteUser() {

        Response response =
                given()
                        .header("Authorization", "Bearer " + bearerToken)  // Bearer Token
                        .log().all()
                        .when()
                        .delete("/user/" + updated_username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(3000L))
                        .extract().response();

        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, updated_username);
    }
}
