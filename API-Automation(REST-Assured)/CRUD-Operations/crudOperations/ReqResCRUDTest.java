package crudOperations;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ReqResCRUDTest extends BaseTest {

    private static final String username = "ujitha";
    private static final String updated_username = "manasa";

    // 1 POST – Create new user
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
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/user/createWithList")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "ok");
    }

    // 2️ GET – Fetch single user
    @Test(priority = 2)
    public void getSingleUser() {

        Response response =
                given()
                        .log().all()
                        .when()
                        .get("/user/" + username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        Assert.assertEquals(response.jsonPath().getString("username"), username);
        Assert.assertNotNull(response.jsonPath().getString("email"));
        Assert.assertEquals(response.jsonPath().getInt("id"), 101);
    }

    // 3️ PUT – Update user
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
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/user/" + username)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "101");
    }

    // 4 DELETE – Remove user
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
                        .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), updated_username);
    }
//     5 GET – Fetch all users
    @Test(priority = 5)
    public void getAllUsers() {
        Response response = given() .when() .get("/user") .then()
                .statusCode(200)
                .extract()
                .response();
        // Validate response body
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
        System.out.println("Total users: " + response.jsonPath()
                .getList("data").size());
    }
}
