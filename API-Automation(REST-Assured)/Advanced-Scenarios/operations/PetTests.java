package operations;

import pojo.Pet;
import pojo.Category;
import pojo.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;

public class PetTests {

    @Test
    public void createPetUsingPOJO() {
        Pet pet = new Pet();
        pet.id = 12345;
        pet.name = "Buddy";
        pet.status = "available";

        Category cat = new Category();
        cat.id = 1;
        cat.name = "Ruby";
        pet.category = cat;

        Tag tag = new Tag();
        tag.id = 101;
        tag.name = "Tag1";
        pet.tags = Arrays.asList(tag);

        Response response = ApiMethods.post("/pet", pet);
        System.out.println(response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Pet creation failed!");
        Assert.assertEquals(response.jsonPath().getInt("id"), 12345);
        Assert.assertEquals(response.jsonPath().getString("name"), "Buddy");
        Assert.assertEquals(response.jsonPath().getString("status"), "available");
    }

    @Test
    public void updatePetUsingPOJO() {
        Pet pet = new Pet();
        pet.id = 12345;
        pet.name = "Honey";
        pet.status = "sold";

        Category cat = new Category();
        cat.id = 1;
        cat.name = "Rubie";
        pet.category = cat;

        Tag tag = new Tag();
        tag.id = 101;
        tag.name = "Tag1";
        pet.tags = Arrays.asList(tag);

        Response response = ApiMethods.put("/pet", pet);
        System.out.println(response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Pet update failed!");
        Assert.assertEquals(response.jsonPath().getString("name"), "Honey");
        Assert.assertEquals(response.jsonPath().getString("status"), "sold");
    }

    @Test
    public void deletePet() {
        Response response = ApiMethods.delete("/pet/12345");
        System.out.println(response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Pet delete failed!");
    }

    @Test
    public void createAndRetrievePet() {
        // Serialize POJO → JSON
        Pet pet = new Pet();
        pet.id = 54321;
        pet.name = "Max";
        pet.status = "available";

        Category cat = new Category();
        cat.id = 2;
        cat.name = "Cats";
        pet.category = cat;
        pet.tags = Arrays.asList(new Tag(){ {id=201; name="Cute";} });

        Response createResp = ApiMethods.post("/pet", pet);
        System.out.println("Create Response: " + createResp.asString());

        // Assertions for creation
        Assert.assertEquals(createResp.getStatusCode(), 200, "Pet creation failed!");
        Assert.assertEquals(createResp.jsonPath().getString("name"), "Max");

        // Deserialize JSON → POJO
        Pet retrievedPet = ApiMethods.get("/pet/54321").as(Pet.class);
        System.out.println("Retrieved Pet Name: " + retrievedPet.name);
        System.out.println("Retrieved Pet Status: " + retrievedPet.status);

        // Assertions
        Assert.assertEquals(retrievedPet.name, "Max");
        Assert.assertEquals(retrievedPet.status, "available");
        Assert.assertEquals(retrievedPet.category.name, "Cats");
    }

    @Test
    public void uploadPetImage() {
        File file = new File("src/test/java/Advance/pet.png");
        Response response = ApiMethods.uploadFile("/pet/12345/uploadImage", file);

        System.out.println(response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Image upload failed!");
        Assert.assertTrue(response.asString().contains("File uploaded"), "Upload message missing!");
    }
}
