package reusablefwcomponents;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTests {

    @Test(priority = 1)
    public void postUser(){
        Response response=ApiMethods.post("/user/createWithList", """
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
                """);
        assert response.statusCode()==200;
    }


    @Test(priority = 2)
    public void getUserTest() {
        Response response = ApiMethods.get("/user/ujitha");
        System.out.println(response.asString());
        assert response.statusCode() == 200;
    }

    @Test(priority = 3)
    public void updateUser(){
        Response response=ApiMethods.put("/user/ujitha","""
                {
                  "id": 101,
                  "username": "manasa",
                  "firstName": "manu",
                  "lastName": "K",
                  "email": "manuuu@gmail.com",
                  "password": "mansa",
                  "phone": "9778536788",
                  "userStatus": 1
                }
                """);
        assert response.statusCode()==200;
    }

    @Test(priority = 4)
    public void deleteUser(){
        Response response=ApiMethods.delete("/user/manasa");
        assert response.statusCode()==200;
    }
}

