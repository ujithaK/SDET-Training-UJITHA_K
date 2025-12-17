import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EndToEndUserFlowTest {

    String token;
    int userId = 1;

    @Test(priority = 1)
    public void createUser() {

        RestAssured.baseURI = "https://dummyjson.com";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body("""
                                {
                                  "firstName": "Ujitha",
                                  "lastName": "K",
                                  "age": 22
                                }
                                """)
                        .when()
                        .post("/users/add")  //Create user
                        .then()
                        .statusCode(201)
                        .extract().response();

        Assert.assertTrue(response.jsonPath().getInt("id") > 0); //storing userId
        System.out.println("User created (mock)");
    }

    @Test(priority = 2)
    public void loginUser() {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        //valid username & password for dummy.json
                        .body("""
                            {
                              "username": "kminchelle",
                              "password": "0lelplR"
                            }
                            """)
                        .when()
                        .post("/auth/login") //Login
                        .then()
                        .statusCode(200)
                        .extract().response();

        token = response.jsonPath().getString("token"); //fetching token.
        Assert.assertNotNull(token, "Token should not be null");

        System.out.println("Token generated: " + token);
    }


    @Test(priority = 3)
    public void updateUser() {
       //Updating user details
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + token)  //Using token for authenticated operations.
                        .body("""
                                {
                                  "firstName": "ujithaReddy"
                                }
                                """)
                        .when()
                        .put("/users/" + userId)
                        .then()
                        .statusCode(200)
                        .extract().response();

        Assert.assertEquals(response.jsonPath().getString("firstName"), "ujithaReddy");
        System.out.println("User updated successfully");
    }

    @Test(priority = 4)
    public void deleteUser() {
    //Deleting user.
        Response response =
                given()
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .delete("/users/" + userId)
                        .then()
                        .statusCode(200)
                        .extract().response();

        Assert.assertTrue(response.jsonPath().getBoolean("isDeleted"));
        System.out.println("User deleted successfully");
    }
}
