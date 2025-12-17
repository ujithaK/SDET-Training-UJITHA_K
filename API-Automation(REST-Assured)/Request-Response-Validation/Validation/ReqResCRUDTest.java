package Validation;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReqResCRUDTest extends BaseTest {

    private static final String username = "haripriya";
    private static final String updated_username = "manasa";

    // 1️ POST – Create new user
    @Test(priority = 1)
    public void createUser() {

        String requestBody = """
                [
                  {
                    "id": 102,
                    "username": "haripriya",
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
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/user/createWithList")
                        .then()
                        .log().all()
                        .statusCode(200)                                 // Status code validation
                        .header("Content-Type", "application/json")      // Header validation
                        .time(org.hamcrest.Matchers.lessThan(2000L))     // Response time validation
                        .extract().response();

        // JSONPath extraction & field assertions
        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, "ok");
    }

    // 2️ GET – Fetch single user
    @Test(priority = 2)
    public void getSingleUser() {

        Response response =
                given()
                        .log().all()
                        .when()
                        .get("/user/haripriya")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(2000L))
                        // JSON Schema validation
                        .body(matchesJsonSchemaInClasspath("schemas/userSchema.json"))
                        .extract().response();

        // JSONPath extraction
        int id = response.jsonPath().getInt("id");
        String uname = response.jsonPath().getString("username");
        String email = response.jsonPath().getString("email");

        // Field assertions
        Assert.assertEquals(id, 101);
        Assert.assertEquals(uname, username);
        Assert.assertTrue(email.contains("@"));
    }

    //  3 PUT – Update user
    @Test(priority = 3)
    public void updateUser() {

        String requestBody = """
                {
                  "id": 101,
                  "username": "manasa",
                  "firstName": "manu",
                  "lastName": "K",
                  "email": "manasa@gmail.com",
                  "password": "newpassword",
                  "phone": "9999999999",
                  "userStatus": 1
                }
                """;

        Response response =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/user/" + username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(2000L))
                        .extract().response();

        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, "101");
    }

    // 4️ DELETE – Remove user
    @Test(priority = 4)
    public void deleteUser() {

        Response response =
                given()
                        .log().all()
                        .when()
                        .delete("/user/" + updated_username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .header("Content-Type", "application/json")
                        .time(org.hamcrest.Matchers.lessThan(2000L))
                        .extract().response();

        int code = response.jsonPath().getInt("code");
        String message = response.jsonPath().getString("message");

        //Validates status code and message
        Assert.assertEquals(code, 200);
        Assert.assertEquals(message, updated_username);
    }
}


