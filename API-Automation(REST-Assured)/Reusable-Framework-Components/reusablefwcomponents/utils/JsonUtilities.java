package reusablefwcomponents.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonUtilities {

    private static final ObjectMapper mapper = new ObjectMapper();


    //Read
    public static <T> T readJsonFile(String path, Class<T> clazz) {
        try {
            return mapper.readValue(new File(path), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON: " + path, e);
        }
    }
   //Write
    public static void writeJsonFile(String path, Object data) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write JSON: " + path, e);
        }
    }
}
