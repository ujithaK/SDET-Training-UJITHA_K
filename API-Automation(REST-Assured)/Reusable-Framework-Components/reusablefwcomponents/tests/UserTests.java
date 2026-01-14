package reusablefwcomponents.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusablefwcomponents.api.ApiMethods;
import reusablefwcomponents.utils.JsonUtilities;
import reusablefwcomponents.pojo.User;

public class UserTests {

    String username = "ujitha_uji";

    @Test(priority = 1)
    public void createUser() {
        User user = JsonUtilities.readJsonFile("src/test/java/reusablefwcomponents/data/user.json", User.class);

        Response response = ApiMethods.post("/user", user);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void getUser() {
        Response response = ApiMethods.get("/user/" + username);
        Assert.assertEquals(response.statusCode(), 200);

        User user = response.as(User.class);
        Assert.assertEquals(user.getUsername(), username);
    }

    @Test(priority = 3)
    public void updateUser() {
        User updated = JsonUtilities.readJsonFile("src/test/java/reusablefwcomponents/data/user.json", User.class);
        updated.setFirstName("Ujitha");

        Response response = ApiMethods.put("/user/" + username, updated);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteUser() {
        Response response = ApiMethods.delete("/user/" + username);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
