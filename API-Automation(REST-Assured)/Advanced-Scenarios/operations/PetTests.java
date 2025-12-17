package operations;


import pojo.Pet;
import pojo.Category;
import pojo.Tag;
import io.restassured.response.Response;
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
        cat.name = "Dogs";
        pet.category = cat;

        Tag tag = new Tag();
        tag.id = 101;
        tag.name = "Tag1";
        pet.tags = Arrays.asList(tag);

        Response response = ApiMethods.post("/pet", pet);
        System.out.println(response.asString());
    }

    @Test
    public void updatePetUsingPOJO() {
        Pet pet = new Pet();
        pet.id = 12345;
        pet.name = "BuddyUpdated";
        pet.status = "sold";

        Category cat = new Category();
        cat.id = 1;
        cat.name = "Dogs";
        pet.category = cat;

        Tag tag = new Tag();
        tag.id = 101;
        tag.name = "Tag1";
        pet.tags = Arrays.asList(tag);

        Response response = ApiMethods.put("/pet", pet);
        System.out.println(response.asString());
    }

    @Test
    public void deletePet() {
        Response response = ApiMethods.delete("/pet/12345");
        System.out.println(response.asString());
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

        // Deserialize JSON → POJO
        Pet retrievedPet = ApiMethods.get("/pet/54321").as(Pet.class);
        System.out.println("Retrieved Pet Name: " + retrievedPet.name);
        System.out.println("Retrieved Pet Status: " + retrievedPet.status);
    }


    @Test
    public void uploadPetImage() {
        File file = new File("src/test/java/Advance/pet.png");
        Response response = ApiMethods.uploadFile("/pet/12345/uploadImage", file);
        System.out.println(response.asString());
    }
}

